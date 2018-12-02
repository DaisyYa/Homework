package it.sevenbits.homework.Grep;

/**
 * factory creates OneWordGreep, OrGrep and AndGrep
 */
public class GrepFactory {
    /**
     * create OneWordGreep
     * @param filter string
     * @return OneWordGreep
     */
    public OneWordGrep getOneWordGrep(final String filter) {
        return new OneWordGrep(filter);
    }

    /**
     * create OrGrep
     * @param filter array of strings
     * @return OrGrep
     */
    public OrGrep getOrGrep(final String[] filter) {
        return new OrGrep(filter);
    }

    /**
     * create getAndGrep
     * @param filter array of strings
     * @return AndGrep
     */
    public AndGrep getAndGrep(final String[] filter) {
        return new AndGrep(filter);
    }
}
