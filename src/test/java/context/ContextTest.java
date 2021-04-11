package context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import service.FileWorker.FileReader;

public class ContextTest {
    @Mock
    private FileReader reader;

    private static final Context context = new Context();


    @Before
    public void setUp() throws  Exception{
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testInitialization() throws Exception {
       // setUp();
        Mockito.when(reader.read("somePath")).thenReturn("This is text");
        context.initialization(reader.read("somePath"));

        Assert.assertEquals("This is text",context.textItem.getContext());

    }
}