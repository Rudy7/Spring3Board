SELECT * FROM board;
SELECT * FROM member;

CREATE table board(
	bbs_seq number primary key,
	title varchar2(20),
	content varchar2(1500),
	writedate date Default sysdate,
	view_count number,
	good number,     
	userid varchar2(20),
	foreign key(userid) references member(userid) on delete cascade
);

create sequence bbsSeq start with 1; 

select * 
from (select rownum NO,
             title,
             content,
             writedate,
             view_count,
             good,
             userid
      from board)t 
where t.NO between ((5-1)*5)+1 and 5*5;









select bbsSeq.currval from dual;
select bbsSeq.nextval from dual;

DROP table board;

INSERT INTO board
VALUES(bbsSeq.nextval, 'n', 'n', sysdate, '2', '2', 'jyw');

select * from user_sequences;
desc bbsSeq;
select bbsSeq.currval from dual;
select bbsSeq.nextval from dual;

DROP table board;
