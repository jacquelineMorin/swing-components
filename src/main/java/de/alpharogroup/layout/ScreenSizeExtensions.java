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
package de.alpharogroup.layout;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import de.alpharogroup.collections.ArrayExtensions;

/**
 * Utility class for handle with screensize.
 *
 * @author Asterios Raptis
 * @version 1.0
 */
public class ScreenSizeExtensions
{

	/**
	 * Compute how much dialog can be put into the screen and returns a list with the coordinates
	 * from the dialog positions as Point objects.
	 *
	 * @param dialogWidth
	 *            the dialog width
	 * @param dialogHeight
	 *            the dialog height
	 * @return the list with the computed Point objects.
	 */
	public static List<Point> computeDialogPositions(final int dialogWidth, final int dialogHeight)
	{
		List<Point> dialogPosition = null;
		final int windowBesides = ScreenSizeExtensions.getScreenWidth() / dialogWidth;
		final int windowBelow = ScreenSizeExtensions.getScreenHeight() / dialogHeight;
		final int listSize = windowBesides * windowBelow;
		dialogPosition = new ArrayList<>(listSize);
		int dotWidth = 0;
		int dotHeight = 0;
		for (int y = 0; y < windowBelow; y++)
		{
			dotWidth = 0;
			for (int x = 0; x < windowBesides; x++)
			{
				final Point p = new Point(dotWidth, dotHeight);
				dialogPosition.add(p);
				dotWidth = dotWidth + dialogWidth;
			}
			dotHeight = dotHeight + dialogHeight;
		}
		return dialogPosition;
	}

	/**
	 * Gets the first screen width.
	 *
	 * @return the first screen width.
	 */
	public static int getFirstScreenHeight()
	{
		final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
			.getLocalGraphicsEnvironment();
		final GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
		int height = getScreenHeight();
		for (final GraphicsDevice graphicsDevice : graphicsDevices)
		{
			final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice
				.getConfigurations();
			final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
				.getFirst(graphicsConfigurations);
			if (graphicsConfiguration != null)
			{
				final Rectangle bounds = graphicsConfiguration.getBounds();
				final double h = bounds.getHeight();
				height = (int)h;
				break;
			}
		}
		return height;
	}

	/**
	 * Gets the first screen width.
	 *
	 * @return the first screen width.
	 */
	public static int getFirstScreenWidth()
	{
		final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
			.getLocalGraphicsEnvironment();
		final GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
		int width = getScreenWidth();
		for (final GraphicsDevice graphicsDevice : graphicsDevices)
		{
			final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice
				.getConfigurations();
			final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
				.getFirst(graphicsConfigurations);
			if (graphicsConfiguration != null)
			{
				final Rectangle bounds = graphicsConfiguration.getBounds();
				final double w = bounds.getWidth();
				width = (int)w;
				break;
			}
		}
		return width;
	}

	/**
	 * Gets the Screensize and returns it as a Point object.
	 *
	 * @return A Point object.
	 */
	public static Point getPoint()
	{
		final Point p = new Point(getScreenWidth(), getScreenHeight());
		return p;
	}

	/**
	 * Gets all the screen devices.
	 *
	 * @return the screen devices
	 */
	public static GraphicsDevice[] getScreenDevices()
	{
		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final GraphicsDevice[] gs = ge.getScreenDevices();
		return gs;
	}

	/**
	 * Gets the height from the current screen.
	 *
	 * @return Returns the height from the current screen.
	 */
	public static int getScreenHeight()
	{
		final int y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		return y;
	}

	/**
	 * Gets the screen height from the given {@link GraphicsDevice} object.
	 *
	 * @param graphicsDevice
	 *            the {@link GraphicsDevice} object.
	 * @return the screen height from the given {@link GraphicsDevice} object.
	 */
	public static int getScreenHeight(final GraphicsDevice graphicsDevice)
	{
		final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice.getConfigurations();
		final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
			.getFirst(graphicsConfigurations);
		if (graphicsConfiguration != null)
		{
			final Rectangle bounds = graphicsConfiguration.getBounds();
			final double height = bounds.getHeight();
			return (int)height;
		}
		return getScreenHeight();
	}

	/**
	 * Gets the width from the current screen.
	 *
	 * @return Returns the width from the current screen.
	 */
	public static int getScreenWidth()
	{
		final int x = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		return x;
	}

	/**
	 * Gets the screen width from the given {@link GraphicsDevice} object.
	 *
	 * @param graphicsDevice
	 *            the {@link GraphicsDevice} object.
	 * @return the screen width from the given {@link GraphicsDevice} object.
	 */
	public static int getScreenWidth(final GraphicsDevice graphicsDevice)
	{
		final GraphicsConfiguration[] graphicsConfigurations = graphicsDevice.getConfigurations();
		final GraphicsConfiguration graphicsConfiguration = ArrayExtensions
			.getFirst(graphicsConfigurations);
		if (graphicsConfiguration != null)
		{
			final Rectangle bounds = graphicsConfiguration.getBounds();
			final double width = bounds.getWidth();
			return (int)width;
		}
		return getScreenWidth();
	}

}
