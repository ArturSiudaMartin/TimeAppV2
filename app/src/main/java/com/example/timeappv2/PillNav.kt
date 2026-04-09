import androidx.compose.animation.animateColorAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timeappv2.TimePeriod
import com.example.timeappv2.syne
import com.example.timeappv2.dmmono

@Composable
fun PillNav(
    selected: TimePeriod,
    onSelect: (TimePeriod) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        TimePeriod.entries.forEach { period ->
            val isActive = period == selected
            val theme = period  // accent and border come from the enum

            val pillBg by animateColorAsState(
                targetValue = if (isActive) theme.accent else Color.Transparent,
                animationSpec = tween(250), label = "pillBg"
            )
            val pillBorder by animateColorAsState(
                targetValue = if (isActive) theme.accent else selected.inactiveBorder,
                animationSpec = tween(250), label = "pillBorder"
            )
            // Text is dark on light accent, light on dark accent
            val textColor by animateColorAsState(
                targetValue = if (isActive) selected.background else selected.textMuted,
                animationSpec = tween(250), label = "pillText"
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(pillBg)
                    .border(1.dp, pillBorder, CircleShape)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { onSelect(period) }
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = period.label.lowercase(),
                    fontFamily = dmmono,
                    fontSize = 10.sp,
                    color = textColor,
                    fontWeight = if (isActive) FontWeight.Medium else FontWeight.Normal
                )
            }
        }
    }
}