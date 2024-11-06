package kishk.ahmedmohamed.tooltipsimulationtask.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import kishk.ahmedmohamed.tooltipsimulationtask.R

@Composable
fun Highlight(
    modifier: Modifier = Modifier,
    tooltipContent: (@Composable () -> Unit)? = null,
    highlighted: Boolean = false,
    highlightSurfaceColor: Color = MaterialTheme.colorScheme.surface,
    highlightSurfaceShape: Shape = RoundedCornerShape(16),
    disableClickWhenHighlighted: Boolean = false,
    dimBackgroundWhenHighlighted: Boolean = true, // when there are multiple items to highlight at the same time set it to false except for the first item that compose
    onClickOutside: () -> Unit,
    content: @Composable () -> Unit,
) {
    var hideOriginalItem by remember { mutableStateOf(false) }
    val density = LocalDensity.current
    val statusBarHeightPx = WindowInsets.statusBars.getTop(density)
    var contentOffset by remember { mutableStateOf(IntOffset.Zero) }
    var contentSizePx by remember { mutableStateOf(IntSize.Zero) }
    var contentSizeDp by remember { mutableStateOf(DpSize.Zero) }

    if (!highlighted) {
        hideOriginalItem = false
    }

    if (!hideOriginalItem) {
        Box(
            modifier = modifier.onGloballyPositioned {
                val pos = it.positionInWindow()
                contentOffset = IntOffset(pos.x.toInt(), pos.y.toInt() - statusBarHeightPx)
                contentSizePx = it.size
                contentSizeDp = it.size.let { size ->
                    DpSize(density.run { size.width.toDp() }, density.run { size.height.toDp() })
                }
            }
        ) {
            content()
        }
    }

    if (highlighted) {
        // Placeholder box for the content
        if (hideOriginalItem)
            Box(modifier = modifier.size(contentSizeDp))

        Dialog(
            onDismissRequest = onClickOutside,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            if (!dimBackgroundWhenHighlighted) {
                val dialogWindowProvider = LocalView.current.parent as? DialogWindowProvider
                dialogWindowProvider?.window?.setDimAmount(0f)
            }
            Box(modifier = Modifier.onFocusChanged {
                hideOriginalItem = true
            }) {
                ItemCopy(
                    modifier = modifier,
                    offsetX = contentOffset.x,
                    offsetY = contentOffset.y,
                    size = contentSizeDp,
                    onClickOutside = onClickOutside,
                    highlightSurfaceColor = highlightSurfaceColor,
                    highlightSurfaceShape = highlightSurfaceShape,
                    disableClick = disableClickWhenHighlighted
                ) {
                    content()
                }
            }
            if (tooltipContent != null) {
                HighlightTooltip(
                    highlightedItemOffset = contentOffset,
                    highlightedItemSize = contentSizePx,
                    content = tooltipContent
                )
            }
        }
    }
}


@Composable
private fun ItemCopy(
    modifier: Modifier = Modifier,
    offsetX: Int,
    offsetY: Int,
    size: DpSize,
    highlightSurfaceColor: Color = MaterialTheme.colorScheme.surface,
    highlightSurfaceShape: Shape = RoundedCornerShape(16),
    disableClick: Boolean,
    onClickOutside: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(modifier = Modifier
        .clickable { onClickOutside() }
        .fillMaxSize()
    ) {
        Box(
            modifier = modifier
                .size(size)
                .offset {
                    IntOffset(offsetX, offsetY)
                }
        ) {
            Surface(
                color = highlightSurfaceColor,
                shape = highlightSurfaceShape
            ) {
                content()
            }
            if (disableClick) {
                Box(modifier = Modifier
                    .size(size)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = {}
                    )
                )
            }
        }
    }
}

@Composable
private fun HighlightTooltip(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    highlightedItemOffset: IntOffset,
    highlightedItemSize: IntSize
) {
    val density = LocalDensity.current
    val tooltipMargin = remember { 12 }
    var rotateIcon by remember { mutableStateOf(false) }
    var tooltipOffsetX by remember { mutableIntStateOf(highlightedItemOffset.x) }
    var tooltipOffsetY by remember { mutableIntStateOf(highlightedItemOffset.y) }
    var arrowOffsetX by remember { mutableIntStateOf(highlightedItemOffset.x) }
    var arrowOffsetY by remember { mutableIntStateOf(highlightedItemOffset.y) }

    BoxWithConstraints {
        Surface(
            modifier = modifier
                .onGloballyPositioned {

                    val tooltipSize = it.size

                    // calculate X offset
                    val parentMaxWidth = density.run { maxWidth.toPx() }
                    val availableHorizontalSpace = parentMaxWidth - highlightedItemOffset.x
                    if (availableHorizontalSpace < tooltipSize.width) {
                        val extra = tooltipSize.width - availableHorizontalSpace
                        tooltipOffsetX = highlightedItemOffset.x - extra.toInt()
                    }
                    arrowOffsetX = highlightedItemOffset.x + (highlightedItemSize.width / 2) - 14

                    // calculate Y offset
                    val dy = tooltipMargin + tooltipSize.height
                    val isBottomSpaceAvailable = highlightedItemOffset.y < dy
                    tooltipOffsetY = if (isBottomSpaceAvailable) {
                        highlightedItemOffset.y + highlightedItemSize.height + tooltipMargin
                    } else {
                        highlightedItemOffset.y - dy
                    }
                    arrowOffsetY = if (isBottomSpaceAvailable) {
                        rotateIcon = true
                        highlightedItemOffset.y + highlightedItemSize.height
                    } else {
                        highlightedItemOffset.y - tooltipMargin
                    }
                }
                .offset {
                    IntOffset(tooltipOffsetX, tooltipOffsetY)
                },
            shape = RoundedCornerShape(8),
            color = MaterialTheme.colorScheme.inverseSurface
        ) {
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.inverseOnSurface) {
                content()
            }
        }
    }

    Icon(
        modifier = Modifier
            .offset {
                IntOffset(arrowOffsetX, arrowOffsetY)
            }
            .rotate(if (rotateIcon) 180f else 0f),
        painter = painterResource(id = R.drawable.ic_tooltip_arrow),
        contentDescription = "Tooltip arrow",
        tint = MaterialTheme.colorScheme.inverseSurface
    )
}
