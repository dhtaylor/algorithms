package linear.and.binary.search.dandy.taylor;

import java.util.Arrays;

/**
 * @author dandy.taylor
 */
public class Search
{

    /**
     *
     * @param <T>
     * @param searchArgument
     * @param itemsToSearch
     * @return Integer
     */
    public static <T extends Comparable<T>> Integer Linear(T searchArgument, T[] itemsToSearch)
    {
        for (int i = 0; i < itemsToSearch.length; i++)
        {

            if (itemsToSearch[i] == null)
            {
                continue;
            }

            if (searchArgument.compareTo(itemsToSearch[i]) == 0)
            {
                return i;
            }
        }

        return -1;

    }

    /**
     *
     * @param <T>
     * @param searchArgument
     * @param itemsToSearch
     * @return Integer
     */
    public static <T extends Comparable<T>> Integer Binary(T searchArgument, T[] itemsToSearch)
    {
        Arrays.sort(itemsToSearch);

        int highIndex = itemsToSearch.length - 1;
        int lowIndex = 0;
        int midPoint;

        while (lowIndex <= highIndex)
        {
            midPoint = lowIndex + (highIndex - lowIndex) / 2;

            int returnValue = searchArgument.compareTo(itemsToSearch[midPoint]);

            if (returnValue == 0)
            {
                return midPoint;
            }

            lowIndex = (returnValue > 0) ? midPoint + 1 : lowIndex;
            highIndex = (returnValue < 0) ? midPoint - 1 : highIndex;

        }

        return -1;

    }

}
