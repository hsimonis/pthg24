#!/bin/bash
while read line; do c=$line;echo $line; for f in $(ls papers/*.pdf); do echo $c $f; done; done < ./pattern.txt