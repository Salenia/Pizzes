package edu.menu.common.interfaces;

import java.util.List;

import edu.menu.common.models.MenuResult;
import edu.menu.common.models.options.OptionGroup;

public interface IViewer {
    
    MenuResult<OptionGroup> multiSelect(List<IOption> options);
}
