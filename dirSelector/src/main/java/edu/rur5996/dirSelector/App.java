package edu.rur5996.dirSelector;

import java.util.List;
import com.google.common.collect.ImmutableList;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = "edu.rur5996", name = "VDs plugin", summary = "And Now, The Other Way Please", version = "1.0.0")
public class App extends Plugin
{
    @Override
    public List<ComponentType> getComponents() {
        return ImmutableList.of(WidgetType.forAnnotatedWidget(DirSelectorWidget.class) );
    }
}
