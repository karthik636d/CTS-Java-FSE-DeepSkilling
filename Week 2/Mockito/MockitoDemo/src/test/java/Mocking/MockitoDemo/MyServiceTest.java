package Mocking.MockitoDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {

        // Step 1: Create Mock Object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub Method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Use Mock Object
        MyService service = new MyService(mockApi);

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }
}