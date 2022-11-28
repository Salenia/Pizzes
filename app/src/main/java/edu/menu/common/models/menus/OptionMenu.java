package edu.menu.common.models.menus;

import edu.menu.common.interfaces.IOption;
import edu.menu.common.models.Menu;

public class OptionMenu extends Menu implements IOption {
    private String m_value = null;

    public void setValue(String newVal) {
        this.m_value = newVal;
    }

    @Override
    public String getDisplayValue() {
        return m_value;
    }
    
}
