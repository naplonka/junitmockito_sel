package suites;

import com.company.DeleteFileMockitoTest;
import com.company.ThrownTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({DeleteFileMockitoTest.class, ThrownTest.class})
public class AllTests {
}
