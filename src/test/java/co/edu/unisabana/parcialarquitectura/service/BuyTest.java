package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;

class BuyTest {

  private final Buy service = new Buy(new Database());

  @Test
  public void test() {
    service.makePurchase(2, 3, "Books");
  }

}