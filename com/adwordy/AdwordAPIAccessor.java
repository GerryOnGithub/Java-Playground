package com.adwordy;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulate downloading some ad words data.
 */
public class AdwordAPIAccessor extends AdwordAccessor {
  @Override
  public List<Adword> getAdwordData() {
    // download using another thread since it is a remote service
    ExecutorService es = Executors.newSingleThreadExecutor();
    Callable<List<Adword>> callable = () -> { return downloadAdwordsData(); };
    Future<List<Adword>> future = es.submit(callable);

    List<Adword> adwords;
    try {
      adwords = future.get();
    }
    catch (InterruptedException | ExecutionException ex) {
      adwords = new ArrayList<>();
      Logger.getLogger(AdwordAPIAccessor.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally {
      es.shutdownNow();
    }
    return adwords;
  }

  /**
   * Simulate invoking the Google API.
   * @return list of Adword
   */
  private List<Adword> downloadAdwordsData() {
    List<Adword> list = new ArrayList<>();

    list.add(new Adword("superduper", 1.0f, 0.10f));
    list.add(new Adword("awesome", 2.0f, 1.00f));
    list.add(new Adword("alright", 99.0f, 50.00f));
    list.add(new Adword("okay", 99.0f, 4.99f));
    list.add(new Adword("dog", 3.0f, 3.02f));
    list.add(new Adword("cat", 2.0f, 2.01f));

    try {
      Thread.sleep(200); // simulate hitting a remote server
    }
    catch (InterruptedException ex) {
      Logger.getLogger(AdwordAPIAccessor.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
  }
}