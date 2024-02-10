package ajiet.ise.postalinfoapp.helper;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helper {

    public static SimpleDateFormat dateFormat_dd_MM_yyyy = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat dateFormat_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormat_dd_MMM_yyyy = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");


    public static String capitalize(String str)
    {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String rsFormat(String value)
    {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setGroupingUsed(true);
        currencyFormat.setMaximumFractionDigits(2);
        return currencyFormat.format(value.replace(",", ""));
    }

    public static String rsFormat(double num)
    {
        NumberFormat currencyFormat = NumberFormat.getNumberInstance();
        currencyFormat.setGroupingUsed(true);
        currencyFormat.setMaximumFractionDigits(2);
        currencyFormat.setMinimumFractionDigits(2);
        return currencyFormat.format(num);
    }

    public static void showSnackbar(View view, String msg)
    {
        if(view != null)
        {
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
        }
    }

    public static String changeDateFormat(String strDate, String patternFrom, String patternTo)
    {
        String result = null;

        SimpleDateFormat sdfFrom = new SimpleDateFormat(patternFrom);
        SimpleDateFormat sdfTo = new SimpleDateFormat(patternTo);
        try
        {
            result = sdfTo.format(sdfFrom.parse(strDate));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return result;

    }
}
