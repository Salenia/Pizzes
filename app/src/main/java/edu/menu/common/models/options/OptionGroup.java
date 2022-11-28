package edu.menu.common.models.options;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.menu.common.interfaces.IOption;

public class OptionGroup implements IOption {
    private List<IOption> m_options;

    public OptionGroup(List<IOption> options) {
        m_options = options;
    }

    public List<IOption> getOptions() {
        return m_options;
    }

    @Override
    public String getDisplayValue() {

        String groupOf = "Group of options:";
        Optional<String> maybeValue = m_options.stream()
                .map(option -> groupOf.concat("\n\t\n" + option.getDisplayValue()))
                .reduce((acc, current) -> acc + current);

        if (!maybeValue.isPresent()) {
            return null;
        } else {
            return groupOf + maybeValue.get();
        }
    }

}
