import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest {

@Test
public void testVerifyInteraction() {

    // Create mock object
    ExternalApi api = mock(ExternalApi.class);

    // Inject mock into service
    MyService service = new MyService(api);

    // Call service method
    service.fetchData();

    // Verify method call
    verify(api).getData();
}

}
