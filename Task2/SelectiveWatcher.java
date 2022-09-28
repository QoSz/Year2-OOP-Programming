// Inherits NewsWatchers Update Method
public class SelectiveWatcher extends NewsWatcher {

  private String categoryWatched;

  public SelectiveWatcher(NewsReporter aNewsReporter, String aCategoryToWatch) {
    theNewsReporter = aNewsReporter;
    categoryWatched = aCategoryToWatch;
    theNewsReporter.attach(this);
  }

  public void update() {
    // Modify this so that it only prints out the update text if the update is an
    // alert for the category being watched

    // prints out the news updates based on the category someone has subscribed to.
    if (categoryWatched.equals(theNewsReporter.getUpdateCategory())) {
      System.out.println("The news watcher watching for " + categoryWatched);
      System.out.println("has received a new alert:");
      System.out.println('"' + theNewsReporter.getUpdateText() + '"');
      System.out.println("");
    }
  }
}
