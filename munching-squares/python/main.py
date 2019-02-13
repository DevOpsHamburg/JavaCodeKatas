#!/usr/bin/env python3

import sys
from PIL import Image, ImageDraw


def main():
    size = 600
    image = Image.new('RGB', (size, size), color='red')
    draw = ImageDraw.Draw(image)

    # Generate munching squares
    for x in range(size):
        for y in range(size):
            draw.point((x, y), (x ^ y) % 256)

    image.save('image.png')


if __name__ == '__main__':
    sys.exit(main())
