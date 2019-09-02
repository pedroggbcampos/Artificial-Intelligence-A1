#!/bin/bash
echo "Environment: $1"
java Main server load $1.in < player2server | java Main verbose > player2server
