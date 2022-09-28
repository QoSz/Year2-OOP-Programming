// Setting up getters and setters to get the latest news.
import java.util.*;

public class NewsReporter {

  private ArrayList<NewsWatcher> observers = new ArrayList<NewsWatcher>();
  private String latestUpdateCategory;
  private String latestUpdateText;

  public void attach(NewsWatcher n) {
    // Complete this method so that it adds the observer to the list of observers
    observers.add(n);
  }

  public void setLatestNews(String theUpdateCategory, String theUpdateText) {
    latestUpdateCategory = theUpdateCategory;
    latestUpdateText = theUpdateText;
    notifyObservers();
  }

  public String getUpdateCategory() {
    return latestUpdateCategory;
  }

  public String getUpdateText() {
    return latestUpdateText;
  }

  private void notifyObservers() {
    // Complete this method to go through each observer in turn,
    // sending it a message to notify that an update has occurred

    // Loops through the list of observers and calls the update method
    for (NewsWatcher n : observers) {
      n.update();
    }
  }
}
