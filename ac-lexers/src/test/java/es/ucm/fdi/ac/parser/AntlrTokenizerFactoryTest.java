/*
 * AC - A source-code copy detector
 *
 *     For more information please visit: http://github.com/manuel-freire/ac2
 *
 * ****************************************************************************
 *
 * This file is part of AC, version 2.x
 *
 * AC is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * AC is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AC.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * AC - A source-code copy detector
 *
 *     For more information please visit:  http://github.com/manuel-freire/ac
 *
 * ****************************************************************************
 *
 * This file is part of AC, version 2.0
 *
 * AC is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * AC is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AC.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ucm.fdi.ac.parser;

import es.ucm.fdi.ac.Analysis;
import es.ucm.fdi.ac.Submission;
import es.ucm.fdi.ac.Tokenizer;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;

public class AntlrTokenizerFactoryTest extends TestCase {

	private static int lastId = 0;

	private static Submission mockSub(String... fileNames) {
		Submission s = new Submission("s" + lastId, "./s" + lastId, lastId);
		for (String name : fileNames) {
			s.addSource(new File(s.getOriginalPath() + "/" + name));
		}
		return s;
	}

	@Test
	public void testGetTokenizerFor() {
		AntlrTokenizerFactory factory = new AntlrTokenizerFactory();

		Submission[] subs = new Submission[] {
				mockSub("foo.c", "bar.h", "quux.whatever"),
				mockSub("VeryVerbose.java", "OverlyLong.java",
						"AnotherClass.java", "OrAnInterface.java"),
				mockSub("LotsOfCamelCase.java", "garbage.gar", "rubbish.rub",
						"tripe.tri") };

		Tokenizer t = factory.getTokenizerFor(subs);
		Tokenizer jt = AntlrTokenizerFactory.TokenizerEntry.forName("foo.java").tokenizer;
		assertEquals(jt, t);
	}
}