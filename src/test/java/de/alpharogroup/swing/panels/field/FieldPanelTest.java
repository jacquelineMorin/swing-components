/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.swing.panels.field;

import java.awt.Frame;

import javax.swing.DefaultComboBoxModel;

import de.alpharogroup.layout.CloseWindow;

/**
 * The test class for {@link FieldPanel}.
 */
public class FieldPanelTest
{

	/**
	 * Test init layout.
	 */

	public static void main(final String[] args)
	{
		final Frame frame = new Frame("FieldPanel");
		frame.addWindowListener(new CloseWindow());
		frame.add(new FieldPanel<String>()
		{

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			@Override
			protected DefaultComboBoxModel<String> newTypeModel()
			{
				return new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" });
			}
		});
		frame.pack();
		frame.setVisible(true);
	}

}
