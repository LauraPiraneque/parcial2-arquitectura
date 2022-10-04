package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BuyTest {

  private final Buy service = new Buy(new Database());
  @InjectMocks
  Database Database;

  @Test
  public void Given_makePurchase_When_buyerCode_equal_vendorCode_Then_return_IllegalSaleException(){
    Buy buy = new Buy(Database);
    assertThrows(IllegalSaleException.class, () -> buy.makePurchase(123, 123, "Papitas"));
  }
  @Test
  public void Given_makePurchase_When_savePurchase_successful_Then_return_Product_sold(){
    Buy buy = new Buy(Database);
    Mockito.when(Database.savePurchase(321, "Papitas")).thenReturn(1);
    assertEquals("Product sold", buy.makePurchase(123,321, "Papitas"));
  }

  @Test
  public void Given_makePurchase_When_savePurchase_failed_Then_return_The_sale_was_not_possible(){
    Buy buy = new Buy(Database);
    Mockito.when(Database.savePurchase(321, "")).thenReturn(0);
    assertEquals("The sale was not possible", buy.makePurchase(123,321, "Papitas"));
  }
}