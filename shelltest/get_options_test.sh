#!/bin/bash
AAA="aaa"
while getopts ":a:bc" opt; do
    case $opt in
        a)
            echo "this is -a, the arg is $OPTARG"
            ;;
        b)  echo "this is -a, there's no arg $OPTARG"
	    AAA=$OPTARG
            ;;
        :)
            echo "missions option arguments: -$OPTARG"
            ;;
        \?)
            echo "Invalid option: -$OPTARG"
            ;;
     esac
done

echo $AAA

