#!/bin/bash

present=$(which htop)

if [ -f $present ]
then
    echo "htop is present"
else
    echo "htop is NOT present..."
    echo "Installing..."
    brew install htop
fi

echo "Starting..."
sleep 5
htop