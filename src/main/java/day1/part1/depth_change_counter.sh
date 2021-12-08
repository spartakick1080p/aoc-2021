#!/bin/sh

input_file=$1
depth_change_count=0

input_array=($(cat $input_file))

for i in "${!input_array[@]}"; do
  curr_val="${input_array[$i]}"
  prev_val="${input_array[$(($i - 1))]}"
  if [ $curr_val -gt $prev_val ]; then
    depth_change_count=$(($depth_change_count + 1))
  fi
done

echo $depth_change_count
