package edu.menu.console;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import edu.menu.common.interfaces.IOption;
import edu.menu.common.interfaces.IViewer;
import edu.menu.common.models.MenuResult;
import edu.menu.common.models.options.OptionGroup;

public class ConsoleViewer implements IViewer {
    // #region Codes
    private static final String CLEAR_AND_HOME_CODE = "\033[H\033[2J";
    private static final String UNSELECTED_CODE = "◎";
    private static final String SELECTED_CODE = "◉";
    // #endregion

    // #region Messages
    private static final String GREET_MULTI_MSG = new ConsoleColor().append("To navigate option, use ")
            .yellow("W & S").append(" keys, to [un]slelect press").yellow(" P").append(", to enter press")
            .yellow(" Enter").append(":").msg();

    private static String SELECTION_OPTION_MSG = "Please select multiple options :)";
    // #endregion

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public MenuResult<OptionGroup> multiSelect(List<IOption> options) {
        var selected = new HashSet<IOption>();
        var hoveredOptionI = 0;
        SelectActionType action = null;
        try {
            do {
                var hoveredOption = options.get(hoveredOptionI);
                clearConsole();
                System.out.println(GREET_MULTI_MSG);
                for (IOption option : options) {
                    var symbol = selected.contains(option) ? SELECTED_CODE : UNSELECTED_CODE;
                    var msg = String.format("\t %s ) %s", symbol, option.getDisplayValue());
                    if (hoveredOption == option) {
                        msg = ConsoleColor.colorln(msg, ConsoleColor.CYAN);
                    }
                    System.out.println(msg);
                }
                System.out.println(SELECTION_OPTION_MSG);

                var res = scanner.nextLine();
                action = fromResponse(res);

                switch (action) {
                    case SELECT:
                        if (selected.contains(hoveredOption)) {
                            selected.remove(hoveredOption);
                        } else {
                            selected.add(hoveredOption);
                        }
                        break;
                    case UP:
                        if (hoveredOptionI > 0) {
                            hoveredOptionI--;
                        }
                        break;
                    case DOWN:
                        var optionsLength = options.toArray().length;
                        hoveredOptionI = hoveredOptionI > optionsLength ? 0 : (hoveredOptionI + 1) % optionsLength;
                        break;
                    case ILLEGAL:
                        throw new Exception("Unpexpected user input: \"" + res + "\"");
                    default:
                        break;
                }
            } while (action != SelectActionType.QUIT);

            return new MenuResult<OptionGroup>(new OptionGroup(selected.stream().toList()), null);
        } catch (Exception e) {
            return new MenuResult<OptionGroup>(null, e);
        }
    }

    private void clearConsole() {
        System.out.print(CLEAR_AND_HOME_CODE);
        System.out.flush();
    }

    private SelectActionType fromResponse(String res) {
        if (res == "") return SelectActionType.QUIT;
        switch (res.toLowerCase().trim().charAt(0)) {
            case 'p':
                return SelectActionType.SELECT;
            case 'w':
                return SelectActionType.UP;
            case 's':
                return SelectActionType.DOWN;
            case '\0':
                return SelectActionType.QUIT;
            default:
                return SelectActionType.ILLEGAL;
        }
    }

    private enum SelectActionType {
        QUIT,
        SELECT,
        UP,
        DOWN,
        ILLEGAL
    }

}
