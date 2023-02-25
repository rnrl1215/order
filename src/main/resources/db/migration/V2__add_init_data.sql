insert into member
values ('rnrl1215',
        'skahn',
        'bc0ff2a90e8dbaadaccc9b956acf1242bc54cf9cfadfd5b318931a3c70ed66c7',
        'nH85DJci92ccyoSV4aeQIA==');


insert into orders
values (1,
        now(),
        now(),
        '123123'
           , now(),
        'READY',
        '김밥',
        'rnrl1215');

insert
into delivery
values (1,
        now(),
        now(),
        now(),
        'NONE',
        1);