package co.edu.unisabana.parcialarquitectura.repository;

import co.edu.unisabana.parcialarquitectura.service.IDatabase;

public class Database implements IDatabase {

  @Override
  public int savePurchase(int buyerCode, String item) {
    if (buyerCode == 0 || item == null || item.isEmpty()) {
      return 0;
    }
    return 1;
  }
}
