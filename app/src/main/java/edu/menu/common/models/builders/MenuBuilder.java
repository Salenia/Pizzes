package edu.menu.common.models.builders;

import edu.menu.common.interfaces.IOption;
import edu.menu.common.interfaces.IViewer;
import edu.menu.common.models.Menu;

public class MenuBuilder {
    protected Menu m_menu = new Menu();

    public MenuBuilder setRenderer(IViewer renderer) {
        m_menu.setRenderer(renderer);
        return this;
    }

    public MenuBuilder addOption(IOption option) {
        m_menu.addOption(option);

        return this;
    }

    public Menu build() {
        return this.m_menu;
    }
}
