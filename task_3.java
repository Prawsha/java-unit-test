// Напиши аннотацию для параметризованных тестов
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)    
public class CheckIsAdultTest {
	
  private final int age;
  private final boolean result;

  public CheckIsAdultTest(int age, boolean result) {
  // Инициализируй поля класса в конструкторе
      this.age = age;
      this.result = result;
  }

  // Пометь метод аннотацией для параметров
  @Parameterized.Parameters  
  public static Object[][] getTextData() {
	return new Object[][] {
            {17, false}, // 17 лет - несовершеннолетний
            {18, true},  // 18 лет - совершеннолетний
            {20, true},  // 20 лет - совершеннолетний
            {21, true}, 
    };
  }

  @Test
  public void checkIsAdultWhenAgeThenResult() {
	Program program = new Program();
	// Передай сюда возраст пользователя
    int actual = age;
    boolean isAdult = program.checkIsAdult(age);
	// Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
    assertEquals("Проверь, что всё хорошо", result, isAdult);
	}
}
