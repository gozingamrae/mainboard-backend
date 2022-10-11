-- 2022/10/08 추가 로그
/* 요청자 : 조동후 | 추가 내용 : 시퀀스 생성 */
CREATE SEQUENCE SEQ_TB_DELIVERY_ADDRESS
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 100000
    NOCYCLE
       NOCACHE
       NOORDER;

/* 요청자 : 이유리 | 추가 내용 : 시퀀스 생성 */
CREATE SEQUENCE SEQ_TB_MEMBER_CODE
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 100000
    NOCYCLE
       NOCACHE
       NOORDER;

/* 요청자 : 박지희 | 추가 내용 : 시퀀스 생성 및 더미 데이터 추가 */
CREATE SEQUENCE SEQ_BOARDGAME_CATEGORY_CODE
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 100000
    NOCYCLE
       NOCACHE
       NOORDER;

INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '여행/파티');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '교육/코딩');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '완구/어린이');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '전략');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '시리즈 게임');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '테마');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '체스/바둑/장기');
INSERT INTO TB_BOARDGAME_CATEGORY VALUES(SEQ_BOARDGAME_CATEGORY_CODE.NEXTVAL, '기타');

CREATE SEQUENCE SEQ_BOARDGAME_TYPE_CODE
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 100000
    NOCYCLE
       NOCACHE
       NOORDER;

INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '염소 위에 염소','N',0,3000,'보드엠','보드엠',1);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '코드네임','N',0,3000,'보드엠','보드엠',1);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '도블','N',0,2700,'코리아보드게임즈','Asmodee',1);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '그것이 문제로다','N',0,1900,'보드엠','보드엠',1);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '드렉사우','N',0,1800,'보드엠','보드엠',1);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '정글 스피드','N',0,1600,'보드엠','보드엠',1);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '두 잇!','N',0,1600,'보드엠','보드엠',2);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '블로커스','N',0,1600,'코리아보드게임즈 ','코리아보드게임즈 ',2);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '고양이가 멍멍!','N',0,1400,'행복한바오밥','행복한바오밥',2);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, 'GO FISH(고피쉬!)','N',0,1200,'행복한바오밥','행복한바오밥',2);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '쿠키 몬스터','N',0,1400,'보드피아','보드피아',3);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '몬스터 체이스','N',0,1400,'보드피아','보드피아',3);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '카우보이 포니','N',0,2800,'코리아보드게임즈','코리아보드게임즈',3);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '핑크퐁 아기상어 메모리 게임','N',0,1000,'학산문화사','학산문화사',3);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '테이크 잇 이지','N',0,2400,'보드피아','보드피아',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '스플렌더','N',0,4000,'코리아보드게임즈','코리아보드게임즈',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '지킬 대 하이드','N',0,1700,'만두게임즈','만두게임즈',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '브라스 랭커셔','N',0,6600,'보드엠','보드엠',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '퀸스 갬빗','N',0,2600,'팝콘에듀','팝콘에듀',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '티켓 투 라이드','N',0,5300,'코리아보드게임즈','코리아보드게임즈',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '이스탄불 주사위 게임','N',0,2200,'코리아보드게임즈','코리아보드게임즈',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '다섯 부족','N',0,6000,'코리아보드게임즈','코리아보드게임즈',4);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '할리갈리','N',0,1200,'코리아보드게임즈','코리아보드게임즈',5);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '러시아워 한글판','N',0,2100,'코리아보드게임즈','코리아보드게임즈',5);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '딕싯 2021','N',0,3300,'코리아보드게임즈','코리아보드게임즈',5);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '카탄','N',0,4000,'코리아보드게임즈','코리아보드게임즈',5);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '우봉고','N',0,3300,'코리아보드게임즈','코리아보드게임즈',5);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '치킨차차','N',0,2600,'코리아보드게임즈','코리아보드게임즈',5);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '체스 앤 체커 (2in1) 자석보드게임','N',0,2600,'(주)에프비존','(주)에프비존',7);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '명인 바둑/체스 M250','N',0,2400,'명인랜드','명인랜드',7);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '명인장기 M109 / M109','N',0,1300,'코리아보드게임즈','코리아보드게임즈',7);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '신의 한수 바둑 장기 세트','N',0,2600,'명인랜드','명인랜드',7);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, '버팔로체스','N',0,1600,'게임올로지','게임올로지',7);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, 'OX 체스','N',0,1600,'게임올로지','게임올로지',7);
INSERT INTO TB_BOARDGAME_TYPE VALUES(SEQ_BOARDGAME_TYPE_CODE.NEXTVAL, 'C35119_피스 컬렉션: 성찰_500피스','N',0,1000,'코리아보드게임즈','코리아보드게임즈',8);

COMMIT; 