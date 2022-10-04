package co.edu.unisabana.parcialarquitectura.service;


public class Buy {

  private IDatabase Idatabase;

  public Buy(IDatabase Idatabase) {
    this.Idatabase = Idatabase;
  }
  public String makePurchase(int vendorCode, int buyerCode, String item) {
    if (buyerCode == vendorCode) {
      throw new IllegalSaleException(vendorCode, buyerCode);
    }
    int result = this.Idatabase.savePurchase(buyerCode, item);
    if (result == 1) {
      return "Product sold";
    } else {
      return "The sale was not possible";
    }
  }
}
