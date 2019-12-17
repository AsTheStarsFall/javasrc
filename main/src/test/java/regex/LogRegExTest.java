package regex;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.*;

public class LogRegExTest {
	Pattern p;

	@Before
	public void testCompile() {
		p = Pattern.compile(LogRegEx.LOG_ENTRY_PATTERN);
		assertNotNull(p);	
	}

	@Test
	public void testApache() {
		Matcher m = p.matcher(LogParseInfo.LOG_ENTRY_LINE);
		assertTrue(m.matches());
		assertTrue(m.groups() > LogParseInfo.MIN_FIELDS);
	}
	@Test
	public void testWildFly() {
		String entry =
		"31.13.103.20 - - [17/Dec/2019:00:05:46 -0500] www.darwinsys.com \"GET /file/ HTTP/1.1\" 200 4225";
		Matcher m = p.matcher(entry);
		assertTrue(m.matches());
		assertTrue(m.groups() > LogParseInfo.MIN_FIELDS);
	}

	@Test
	public void testWildFly2() {
		String entry =
		"static.82.118.76.144.clients.your-server.de - - [17/Dec/2019:00:16:44 -0500] theories.darwinsys.com \"GET /ByCategory.web;jsessionid=3JtspVtEyY5cz9Z25KFFaU2Kr3ydneC5Xd6ioOV4.darwinsys?category=travel HTTP/1.1\" 200 12935";
		assertTrue(m.matches());
		Matcher m = p.matcher(entry);
	}
}
