from urllib.request import Request, urlopen
import json, os
import csv
import sys
import time

print('WARNING: Always Backup your XTEAs the new XTEAs may no longer work.')
print('NOTE: You will need to update this script when RuneLite.net updates.')
wait = input("PRESS ENTER TO CONTINUE.")

req = Request('https://api.runelite.net/runelite-1.3.6/xtea', headers={'User-Agent': 'Mozilla/5.0'})
json_data = json.loads(urlopen(req).read().decode())
 
if not os.path.exists('./get-xteas/xtea/maps'):
    os.makedirs('./get-xteas/xtea/maps')
 
zero_count = 0
counter = 1
 
for j in json_data:
        with open("./get-xteas/xtea/maps/" + str(j['region']) + '.txt', 'w') as f:
            list_length = len(j['keys'])
            for key in j['keys']:
                if counter == 4:
                    f.write(str(key))
                else:
                    f.write(str(key) + "\n")
                counter += 1
 
 
print('...DONE!')
wait = input("PRESS ENTER TO EXIT.")
