package edu.menu.common.models;

import java.util.ArrayList;

import edu.menu.common.interfaces.IOption;
import edu.menu.common.interfaces.IViewer;
import edu.menu.common.models.builders.MenuBuilder;
import edu.menu.common.models.options.OptionGroup;

public class Menu {
    protected IViewer out;
    protected ArrayList<IOption> m_options = new ArrayList<>();

    public void setRenderer(IViewer viewer) {
        this.out = viewer;
    }

    public void addOption(IOption option) {
        m_options.add(option);
    }

    public static MenuBuilder builder() {
        return new MenuBuilder();
    }

    public MenuResult<OptionGroup> select() {
        return out.multiSelect(m_options);
    }
}
