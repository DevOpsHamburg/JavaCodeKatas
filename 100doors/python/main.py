#!/usr/bin/env python

import sys


def print_doors(doors):
    cnt = 1
    for i in doors:
        if i == 1:
            print("Door {0}: open".format(cnt))
        cnt += 1


def main():
    doors = []
    for i in range(100):
        doors.append(0)

    step = 1
    for j in range(100):
        for i in range(j, 100, step):
            doors[i] = int(not(doors[i]))
        step += 1

    print_doors(doors)


if __name__ == "__main__":
    sys.exit(main())