
/**
 * 
 * 
 * @author Cameron Sullivan
 * @version 2016.1.30
 */
public interface FundControl
{
     // Ensure that certain methods are implemented by all sector classes.
     void buyStock(int sharesToBuy, int id);
     void invest(int months);
     void sellStock(int sharesToSell);
     double getSharePrice();
     int getShareNum();
     double getInvestment();
     double getBalance();
}