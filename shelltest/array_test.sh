
ARRARY=("a" "b" "c")
idx=0
while [ "x${ARRAY[idx]}" != "x" ];do
    echo "${ARRAY[idx]}"
    idx=$(($idx+1))
done
    
