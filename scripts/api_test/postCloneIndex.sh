#!/usr/bin/env bash

PORT=${1:-8888}
INDEX_NAME_SRC=${2:-index_getjenny_english_0}
INDEX_NAME_DST=${3:-index_getjenny_english_0_preview}

curl -v -H "Authorization: Basic $(echo -n 'admin:adminp4ssw0rd' | base64)" \
  -H "Content-Type: application/json" -X POST "http://localhost:${PORT}/${INDEX_NAME_SRC}/decisiontable/clone/${INDEX_NAME_DST}" -d'{}'
