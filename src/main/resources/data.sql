INSERT INTO mys.ADDRESS(STREET_NAME, CITY) values('STREET 1','Bangalore');
INSERT INTO mys.ADDRESS(STREET_NAME, CITY) values('STREET 2','Chennai');
INSERT INTO mys.ADDRESS(STREET_NAME, CITY) values('STREET 3','Bangalore');

INSERT INTO mys.CLIENT(FST_NAME,LST_NAME,MID_NAME,ADDRESS_ID) values('C1','ABC','N',select ADDRESS_ID from mys.ADDRESS where STREET_NAME='STREET 1');
INSERT INTO mys.CLIENT(FST_NAME,LST_NAME,MID_NAME,ADDRESS_ID) values('C2','ABC','N',select ADDRESS_ID from mys.ADDRESS where STREET_NAME='STREET 2');
INSERT INTO mys.CLIENT(FST_NAME,LST_NAME,MID_NAME,ADDRESS_ID) values('C3','ABC','N',select ADDRESS_ID from mys.ADDRESS where STREET_NAME='STREET 3');

