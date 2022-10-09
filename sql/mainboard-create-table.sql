DROP TABLE TB_PRODUCT;

CREATE TABLE TB_PRODUCT
(
    PRODUCT_CODE    NUMBER NOT NULL,
    PRODUCT_NAME    VARCHAR2(60) NOT NULL,
    RATING    VARCHAR2(10) NOT NULL,
    RENTAL_PERRIOD    NUMBER NOT NULL,
    SOLD_OUT_YN    CHAR(1) NOT NULL,
    SORTATION    VARCHAR2(10) NOT NULL,
    DISCOUNTED_RENTAL_FEE    NUMBER NOT NULL,
    RATING_CODE    VARCHAR2(20) NOT NULL,
    BOARDGAME_TYPE_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_PRODUCT.PRODUCT_CODE IS '상품코드';

COMMENT ON COLUMN TB_PRODUCT.PRODUCT_NAME IS '상품명';

COMMENT ON COLUMN TB_PRODUCT.RATING IS '등급';

COMMENT ON COLUMN TB_PRODUCT.RENTAL_PERRIOD IS '대여 기간';

COMMENT ON COLUMN TB_PRODUCT.SOLD_OUT_YN IS '품절여부';

COMMENT ON COLUMN TB_PRODUCT.SORTATION IS '구분';

COMMENT ON COLUMN TB_PRODUCT.DISCOUNTED_RENTAL_FEE IS '할인이 적용된 대여료';

COMMENT ON COLUMN TB_PRODUCT.RATING_CODE IS '등급코드';

COMMENT ON COLUMN TB_PRODUCT.BOARDGAME_TYPE_CODE IS '보드게임 종류 코드';

COMMENT ON TABLE TB_PRODUCT IS '상품';

CREATE UNIQUE INDEX TB_PRODUCT_PK ON TB_PRODUCT
    ( PRODUCT_CODE );

ALTER TABLE TB_PRODUCT
    ADD CONSTRAINT TB_PRODUCT_PK PRIMARY KEY ( PRODUCT_CODE )
    USING INDEX TB_PRODUCT_PK;


DROP TABLE TB_BOARDGAME_STOCK;

CREATE TABLE TB_BOARDGAME_STOCK
(
    SERIAL_CODE    NUMBER NOT NULL,
    BOARDGAME_TYPE_CODE    NUMBER NOT NULL,
    STORAGE_LOCATION    VARCHAR2(60) NOT NULL,
    RENTAL_CYCLE    VARCHAR2(20) NOT NULL,
    RATING_CODE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_BOARDGAME_STOCK.SERIAL_CODE IS '시리얼코드';

COMMENT ON COLUMN TB_BOARDGAME_STOCK.BOARDGAME_TYPE_CODE IS '보드게임 종류 코드';

COMMENT ON COLUMN TB_BOARDGAME_STOCK.STORAGE_LOCATION IS '보관위치';

COMMENT ON COLUMN TB_BOARDGAME_STOCK.RENTAL_CYCLE IS '대여사이클';

COMMENT ON COLUMN TB_BOARDGAME_STOCK.RATING_CODE IS '등급코드';

COMMENT ON TABLE TB_BOARDGAME_STOCK IS '보드게임 재고';

CREATE UNIQUE INDEX TB_BOARDGAME_STOCK_PK ON TB_BOARDGAME_STOCK
    ( SERIAL_CODE );

ALTER TABLE TB_BOARDGAME_STOCK
    ADD CONSTRAINT TB_BOARDGAME_STOCK_PK PRIMARY KEY ( SERIAL_CODE )
    USING INDEX TB_BOARDGAME_STOCK_PK;


DROP TABLE TB_REVIEW;

CREATE TABLE TB_REVIEW
(
    REVIEW_CODE    NUMBER NOT NULL,
    RENTAL_INFO_CODE    NUMBER NOT NULL,
    REVIEW_SCORE    NUMBER NOT NULL,
    REVIEW_BLOCK_YN    CHAR(1) NOT NULL,
    REVIEW_POINT    NUMBER NOT NULL,
    MEMBER_CODED    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_REVIEW.REVIEW_CODE IS '리뷰코드';

COMMENT ON COLUMN TB_REVIEW.RENTAL_INFO_CODE IS '대여정보코드';

COMMENT ON COLUMN TB_REVIEW.REVIEW_SCORE IS '별점';

COMMENT ON COLUMN TB_REVIEW.REVIEW_BLOCK_YN IS '리뷰차단여부';

COMMENT ON COLUMN TB_REVIEW.REVIEW_POINT IS '지급포인트';

COMMENT ON COLUMN TB_REVIEW.MEMBER_CODED IS '작성 회원번호';

COMMENT ON TABLE TB_REVIEW IS '리뷰';

CREATE UNIQUE INDEX TB_REVIEW_PK ON TB_REVIEW
    ( REVIEW_CODE );

ALTER TABLE TB_REVIEW
    ADD CONSTRAINT TB_REVIEW_PK PRIMARY KEY ( REVIEW_CODE )
    USING INDEX TB_REVIEW_PK;


DROP TABLE TB_DISCOUNT_RATE;

CREATE TABLE TB_DISCOUNT_RATE
(
    DISCOUNT_RATE_CODE    VARCHAR2(20) NOT NULL,
    RENTAL_PERIOD    VARCHAR2(20) NOT NULL,
    DISCOUNT_RATE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_DISCOUNT_RATE.DISCOUNT_RATE_CODE IS '할인률 코드';

COMMENT ON COLUMN TB_DISCOUNT_RATE.RENTAL_PERIOD IS '대여 일자';

COMMENT ON COLUMN TB_DISCOUNT_RATE.DISCOUNT_RATE IS '할인률';

COMMENT ON TABLE TB_DISCOUNT_RATE IS '할인률';

CREATE UNIQUE INDEX TB_DISCOUNT_RATE_PK ON TB_DISCOUNT_RATE
    ( DISCOUNT_RATE_CODE );

ALTER TABLE TB_DISCOUNT_RATE
    ADD CONSTRAINT TB_DISCOUNT_RATE_PK PRIMARY KEY ( DISCOUNT_RATE_CODE )
    USING INDEX TB_DISCOUNT_RATE_PK;


DROP TABLE TB_PAYMENT_HISTORY;

CREATE TABLE TB_PAYMENT_HISTORY
(
    PAYMENT_CODE    VARCHAR2(20) NOT NULL,
    ORDER_CODE    VARCHAR2(20) NOT NULL,
    ORDER_AMOUNT    NUMBER NOT NULL,
    PAYMENT_DATE    VARCHAR2(20) NOT NULL,
    MEMBER_CODE    VARCHAR2(20) NOT NULL,
    PAYMENT_METHOD    VARCHAR2(20) NOT NULL,
    DELIVERY_CHARGE    NUMBER NOT NULL,
    COUPON_USED_AMOUNT    NUMBER,
    POINTS_USED_AMOUNT    NUMBER,
    FINAL_PAYMENT_AMOUNT    NUMBER NOT NULL,
    PAYMENT_STATUS    VARCHAR2(10) NOT NULL,
    CHANGE_CODE    VARCHAR2(20) NOT NULL,
    HOLD_COUPON_CODE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_PAYMENT_HISTORY.PAYMENT_CODE IS '결제코드';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.ORDER_CODE IS '주문코드';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.MEMBER_CODE IS '회원';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.PAYMENT_DATE IS '결제일시';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.PAYMENT_METHOD IS '결제수단';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.DELIVERY_CHARGE IS '배송비';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.COUPON_USED_AMOUNT IS '쿠폰사용금액';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.POINTS_USED_AMOUNT IS '포인트사용금액';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.ORDER_AMOUNT IS '주문금액';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.FINAL_PAYMENT_AMOUNT IS '최종결제금액';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.PAYMENT_STATUS IS '결제 상태';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.CHANGE_CODE IS '변경코드';

COMMENT ON COLUMN TB_PAYMENT_HISTORY.HOLD_COUPON_CODE IS '보유쿠폰코드';

COMMENT ON TABLE TB_PAYMENT_HISTORY IS '결제내역';

CREATE UNIQUE INDEX TB_PAYMENT_HISTORY_PK ON TB_PAYMENT_HISTORY
    ( PAYMENT_CODE );

ALTER TABLE TB_PAYMENT_HISTORY
    ADD CONSTRAINT TB_PAYMENT_HISTORY_PK PRIMARY KEY ( PAYMENT_CODE )
    USING INDEX TB_PAYMENT_HISTORY_PK;


DROP TABLE TB_DELIVERY;

CREATE TABLE TB_DELIVERY
(
    DELIVERY_CODE    NUMBER NOT NULL,
    ORDER_CODE    VARCHAR2(20) NOT NULL,
    ADDRESS_CODE    NUMBER NOT NULL,
    TRACKING_NUMBER    NUMBER NOT NULL,
    CURRENT_LOCATION    VARCHAR2(255) NOT NULL,
    DELIVERY_ESTIMATED_END_DATE    VARCHAR2(30) NOT NULL,
    RETURNING_YN    CHAR(1) NOT NULL,
    DELIVERY_START_DATE    VARCHAR2(30) NOT NULL,
    DELIVERY_END_DATE    VARCHAR2(30),
    EXPLANATION    VARCHAR2(600),
    DELIVERY_PRODUCT_CODE    NUMBER NOT NULL,
    SERIAL_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_DELIVERY.DELIVERY_CODE IS '배송코드';

COMMENT ON COLUMN TB_DELIVERY.ORDER_CODE IS '주문코드';

COMMENT ON COLUMN TB_DELIVERY.ADDRESS_CODE IS '배송지코드';

COMMENT ON COLUMN TB_DELIVERY.TRACKING_NUMBER IS '운송장번호';

COMMENT ON COLUMN TB_DELIVERY.CURRENT_LOCATION IS '현재위치';

COMMENT ON COLUMN TB_DELIVERY.DELIVERY_ESTIMATED_END_DATE IS '예상배송일';

COMMENT ON COLUMN TB_DELIVERY.RETURNING_YN IS '회송여부';

COMMENT ON COLUMN TB_DELIVERY.DELIVERY_START_DATE IS '배송일자';

COMMENT ON COLUMN TB_DELIVERY.DELIVERY_END_DATE IS '도착일자';

COMMENT ON COLUMN TB_DELIVERY.EXPLANATION IS '특이사항';

COMMENT ON COLUMN TB_DELIVERY.DELIVERY_PRODUCT_CODE IS '배송 상품 코드';

COMMENT ON COLUMN TB_DELIVERY.SERIAL_CODE IS '시리얼코드';

COMMENT ON TABLE TB_DELIVERY IS '배송';

CREATE UNIQUE INDEX TB_DELIVERY_PK ON TB_DELIVERY
    ( DELIVERY_CODE );

ALTER TABLE TB_DELIVERY
    ADD CONSTRAINT TB_DELIVERY_PK PRIMARY KEY ( DELIVERY_CODE )
    USING INDEX TB_DELIVERY_PK;


DROP TABLE TB_STATISTICS_BOARDGAME_STATUS;

CREATE TABLE TB_STATISTICS_BOARDGAME_STATUS
(
    DATA_COLLECTION_DATE    VARCHAR2(20) NOT NULL,
    BOARDGAME_STATUS    VARCHAR2(20) NOT NULL,
    BOARDGAME_RENTAL_COUNT    NUMBER,
    BOARDGAME_SALES    NUMBER
);

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_STATUS.DATA_COLLECTION_DATE IS '데이터 수집 날짜';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_STATUS.BOARDGAME_STATUS IS '보드게임 상태';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_STATUS.BOARDGAME_RENTAL_COUNT IS '보드게임 대여 횟수';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_STATUS.BOARDGAME_SALES IS '보드게임 매출액';

COMMENT ON TABLE TB_STATISTICS_BOARDGAME_STATUS IS '보드게임 상태 별 통계';

CREATE UNIQUE INDEX TB_STATISTICS_BOARDGAME_STATUS_PK ON TB_STATISTICS_BOARDGAME_STATUS
    ( DATA_COLLECTION_DATE );

ALTER TABLE TB_STATISTICS_BOARDGAME_STATUS
    ADD CONSTRAINT TB_STATISTICS_BOARDGAME_STATUS_PK PRIMARY KEY ( DATA_COLLECTION_DATE )
    USING INDEX TB_STATISTICS_BOARDGAME_STATUS_PK;


DROP TABLE TB_REASON_RECALLING_POINTS;

CREATE TABLE TB_REASON_RECALLING_POINTS
(
    REASON_RECALLING_POINTS_CODE    VARCHAR2(20) NOT NULL,
    REASON_RECALLING_POINTS    VARCHAR2(100) NOT NULL,
    CHAGE_CODE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_REASON_RECALLING_POINTS.REASON_RECALLING_POINTS_CODE IS '포인트 회수 사유 코드';

COMMENT ON COLUMN TB_REASON_RECALLING_POINTS.REASON_RECALLING_POINTS IS '포인트 회수 사유';

COMMENT ON COLUMN TB_REASON_RECALLING_POINTS.CHAGE_CODE IS '변경코드';

COMMENT ON TABLE TB_REASON_RECALLING_POINTS IS '포인트 회수 사유';

CREATE UNIQUE INDEX TB_REASON_RECALLING_POINTS_PK ON TB_REASON_RECALLING_POINTS
    ( REASON_RECALLING_POINTS_CODE );

ALTER TABLE TB_REASON_RECALLING_POINTS
    ADD CONSTRAINT TB_REASON_RECALLING_POINTS_PK PRIMARY KEY ( REASON_RECALLING_POINTS_CODE )
    USING INDEX TB_REASON_RECALLING_POINTS_PK;


DROP TABLE TB_INSPECTION_HISTORY;

CREATE TABLE TB_INSPECTION_HISTORY
(
    INSPECTION_CODE    NUMBER NOT NULL,
    INSPECTION_PASS_YN    CHAR(1) NOT NULL,
    INSPECTION_DATE    VARCHAR2(30) NOT NULL,
    INSPECTOR    VARCHAR2(30) NOT NULL,
    INSPECTED_BOARDGAME_SERIAL_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_INSPECTION_HISTORY.INSPECTION_CODE IS '검수코드';

COMMENT ON COLUMN TB_INSPECTION_HISTORY.INSPECTION_PASS_YN IS '검수합격여부';

COMMENT ON COLUMN TB_INSPECTION_HISTORY.INSPECTION_DATE IS '검수일자';

COMMENT ON COLUMN TB_INSPECTION_HISTORY.INSPECTOR IS '검수자';

COMMENT ON COLUMN TB_INSPECTION_HISTORY.INSPECTED_BOARDGAME_SERIAL_CODE IS '검수한 보드게임의 시리얼 코드';

COMMENT ON TABLE TB_INSPECTION_HISTORY IS '검수 이력';

CREATE UNIQUE INDEX TB_INSPECTION_HISTORY_PK ON TB_INSPECTION_HISTORY
    ( INSPECTION_CODE );

ALTER TABLE TB_INSPECTION_HISTORY
    ADD CONSTRAINT TB_INSPECTION_HISTORY_PK PRIMARY KEY ( INSPECTION_CODE )
    USING INDEX TB_INSPECTION_HISTORY_PK;


DROP TABLE TB_INSPECTION_PARTS_INSPECTION_RESULT;

CREATE TABLE TB_INSPECTION_PARTS_INSPECTION_RESULT
(
    INSPECTION_CODE    NUMBER NOT NULL,
    RESULT    VARCHAR2(60) NOT NULL,
    STOCK_PARTS_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_INSPECTION_PARTS_INSPECTION_RESULT.INSPECTION_CODE IS '검수코드';

COMMENT ON COLUMN TB_INSPECTION_PARTS_INSPECTION_RESULT.RESULT IS '결과';

COMMENT ON COLUMN TB_INSPECTION_PARTS_INSPECTION_RESULT.STOCK_PARTS_CODE IS '재고별 보유 부품 코드';

COMMENT ON TABLE TB_INSPECTION_PARTS_INSPECTION_RESULT IS '검수 별 부품 검수 결과';

CREATE UNIQUE INDEX TB_INSPECTION_PARTS_INSPECTION_RESULT_PK ON TB_INSPECTION_PARTS_INSPECTION_RESULT
    ( INSPECTION_CODE );

ALTER TABLE TB_INSPECTION_PARTS_INSPECTION_RESULT
    ADD CONSTRAINT TB_INSPECTION_PARTS_INSPECTION_RESULT_PK PRIMARY KEY ( INSPECTION_CODE )
    USING INDEX TB_INSPECTION_PARTS_INSPECTION_RESULT_PK;


DROP TABLE TB_RECEIVING_POSTING_HISTORY;

CREATE TABLE TB_RECEIVING_POSTING_HISTORY
(
    RECEIVING_POSTING_CODE    NUMBER NOT NULL,
    RENTAL_CODE    NUMBER NOT NULL,
    RECEIVING_POSTING_DATE    VARCHAR2(30) NOT NULL,
    SORTATION    VARCHAR2(10) NOT NULL,
    STOCK_SERIAL_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_RECEIVING_POSTING_HISTORY.RECEIVING_POSTING_CODE IS '입출고 코드';

COMMENT ON COLUMN TB_RECEIVING_POSTING_HISTORY.RENTAL_CODE IS '대여코드';

COMMENT ON COLUMN TB_RECEIVING_POSTING_HISTORY.RECEIVING_POSTING_DATE IS '일자';

COMMENT ON COLUMN TB_RECEIVING_POSTING_HISTORY.SORTATION IS '구분';

COMMENT ON COLUMN TB_RECEIVING_POSTING_HISTORY.STOCK_SERIAL_CODE IS '재고 시리얼코드';

COMMENT ON TABLE TB_RECEIVING_POSTING_HISTORY IS '입,출고 이력';

CREATE UNIQUE INDEX TB_RECEIVING_POSTING_HISTORY_PK ON TB_RECEIVING_POSTING_HISTORY
    ( RECEIVING_POSTING_CODE );

ALTER TABLE TB_RECEIVING_POSTING_HISTORY
    ADD CONSTRAINT TB_RECEIVING_POSTING_HISTORY_PK PRIMARY KEY ( RECEIVING_POSTING_CODE )
    USING INDEX TB_RECEIVING_POSTING_HISTORY_PK;


DROP TABLE TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT;

CREATE TABLE TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT
(
    INSPECTION_CHECK_LIST_RESULT_CODE    NUMBER NOT NULL,
    LIST_CODE    NUMBER NOT NULL,
    INSPECTION_CODE    NUMBER NOT NULL,
    RESULT    VARCHAR2(60) NOT NULL
);

COMMENT ON COLUMN TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT.INSPECTION_CHECK_LIST_RESULT_CODE IS '체크 목록 검수 결과 코드';

COMMENT ON COLUMN TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT.LIST_CODE IS '목록코드';

COMMENT ON COLUMN TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT.INSPECTION_CODE IS '검수코드';

COMMENT ON COLUMN TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT.RESULT IS '결과';

COMMENT ON TABLE TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT IS '보드게임별 체크 목록 검수 결과';

CREATE UNIQUE INDEX TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT_PK ON TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT
    ( INSPECTION_CHECK_LIST_RESULT_CODE );

ALTER TABLE TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT
    ADD CONSTRAINT TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT_PK PRIMARY KEY ( INSPECTION_CHECK_LIST_RESULT_CODE )
    USING INDEX TB_BOARDGAME_CHECK_LIST_INSPECTION_RESULT_PK;


DROP TABLE TB_BOARDGAME_TYPE;

CREATE TABLE TB_BOARDGAME_TYPE
(
    BOARDGAME_TYPE_CODE    NUMBER NOT NULL,
    BOARDGAME_NAME    VARCHAR2(90) NOT NULL,
    SOLD_OUT_YN    CHAR(1) NOT NULL,
    TOTAL_COUNT    NUMBER NOT NULL,
    DEFAULT_RENTAL_FEE    NUMBER NOT NULL,
    MANUFACTURING_COMPANY VARCHAR2(255),
    BRAND VARCHAR2(255),
    BOARDGAME_CATEGORY_CODE    NUMBER NOT NULL --보드게임 카테고리 칼럼 추가
);

COMMENT ON COLUMN TB_BOARDGAME_TYPE.BOARDGAME_TYPE_CODE IS '보드게임 종류 코드';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.BOARDGAME_NAME IS '보드게임명';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.SOLD_OUT_YN IS '품절 여부';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.TOTAL_COUNT IS '총 개수';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.DEFAULT_RENTAL_FEE IS '기본 대여료';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.BRAND IS '브랜드';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.MANUFACTURING_COMPANY IS '제조사';

COMMENT ON COLUMN TB_BOARDGAME_TYPE.BOARDGAME_CATEGORY_CODE IS '보드게임 카테고리 코드';

COMMENT ON TABLE TB_BOARDGAME_TYPE IS '보드게임 종류';


CREATE UNIQUE INDEX TB_BOARDGAME_TYPE_PK ON TB_BOARDGAME_TYPE
    ( BOARDGAME_TYPE_CODE );

ALTER TABLE TB_BOARDGAME_TYPE
    ADD CONSTRAINT TB_BOARDGAME_TYPE_PK PRIMARY KEY ( BOARDGAME_TYPE_CODE )
    USING INDEX TB_BOARDGAME_TYPE_PK;

DROP TABLE TB_STATISTICS_BOARDGAME_TYPE;

CREATE TABLE TB_STATISTICS_BOARDGAME_TYPE
(
    DATA_COLLECTION_DATE    VARCHAR2(20) NOT NULL,
    BOARDGAME_CODE    VARCHAR2(20) NOT NULL,
    BOARDGAME_RENTAL_COUNT    NUMBER,
    BOARDGAME_SALES    NUMBER
);

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_TYPE.DATA_COLLECTION_DATE IS '데이터 수집 날짜';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_TYPE.BOARDGAME_CODE IS '보드게임 종류 코드';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_TYPE.BOARDGAME_RENTAL_COUNT IS '보드게임 대여 횟수';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_TYPE.BOARDGAME_SALES IS '보드게임 매출액';

COMMENT ON TABLE TB_STATISTICS_BOARDGAME_TYPE IS '보드게임 종류 별 통계';

CREATE UNIQUE INDEX TB_STATISTICS_BOARDGAME_TYPE_PK ON TB_STATISTICS_BOARDGAME_TYPE
    ( DATA_COLLECTION_DATE );

ALTER TABLE TB_STATISTICS_BOARDGAME_TYPE
    ADD CONSTRAINT TB_STATISTICS_BOARDGAME_TYPE_PK PRIMARY KEY ( DATA_COLLECTION_DATE )
    USING INDEX TB_STATISTICS_BOARDGAME_TYPE_PK;


DROP TABLE TB_RENTAL_INFO;

CREATE TABLE TB_RENTAL_INFO
(
    RENTAL_INFORMATION_CODE    VARCHAR2(20) NOT NULL,
    RENTAL_FEE    NUMBER NOT NULL,
    RETURN_DATE    VARCHAR2(20) NOT NULL,
    MEMBER_CODE    VARCHAR2(20) NOT NULL,
    ORDER_CODE    VARCHAR2(20) NOT NULL,
    PRODUCT_CODE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_RENTAL_INFO.RENTAL_INFORMATION_CODE IS '대여정보코드';

COMMENT ON COLUMN TB_RENTAL_INFO.RENTAL_FEE IS '대여료';

COMMENT ON COLUMN TB_RENTAL_INFO.RETURN_DATE IS '반납예정일';

COMMENT ON COLUMN TB_RENTAL_INFO.MEMBER_CODE IS '회원코드';

COMMENT ON COLUMN TB_RENTAL_INFO.ORDER_CODE IS '주문코드';

COMMENT ON COLUMN TB_RENTAL_INFO.PRODUCT_CODE IS '상품코드';

COMMENT ON TABLE TB_RENTAL_INFO IS '대여정보';

CREATE UNIQUE INDEX TB_RENTAL_INFO_PK ON TB_RENTAL_INFO
    ( RENTAL_INFORMATION_CODE );

ALTER TABLE TB_RENTAL_INFO
    ADD CONSTRAINT TB_RENTAL_INFO_PK PRIMARY KEY ( RENTAL_INFORMATION_CODE )
    USING INDEX TB_RENTAL_INFO_PK;


DROP TABLE TB_RENTAL_PRERIOD_DISCOUNT_RATE;

CREATE TABLE TB_RENTAL_PRERIOD_DISCOUNT_RATE
(
    RENTAL_PERRIOD    NUMBER NOT NULL,
    DISCOUNT_RATE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_RENTAL_PRERIOD_DISCOUNT_RATE.RENTAL_PERRIOD IS '대여 기간';

COMMENT ON COLUMN TB_RENTAL_PRERIOD_DISCOUNT_RATE.DISCOUNT_RATE IS '할인률';

COMMENT ON TABLE TB_RENTAL_PRERIOD_DISCOUNT_RATE IS '대여기간별 할인률';

CREATE UNIQUE INDEX TB_RENTAL_PRERIOD_DISCOUNT_RATE_PK ON TB_RENTAL_PRERIOD_DISCOUNT_RATE
    ( RENTAL_PERRIOD );

ALTER TABLE TB_RENTAL_PRERIOD_DISCOUNT_RATE
    ADD CONSTRAINT TB_RENTAL_PRERIOD_DISCOUNT_RATE_PK PRIMARY KEY ( RENTAL_PERRIOD )
    USING INDEX TB_RENTAL_PRERIOD_DISCOUNT_RATE_PK;


DROP TABLE TB_DETAIL_INSEPECTION_ITEM_VALUE;

CREATE TABLE TB_DETAIL_INSEPECTION_ITEM_VALUE
(
    LIST_CODE    NUMBER NOT NULL,
    LIST_ITEM    VARCHAR2(600) NOT NULL
);

COMMENT ON COLUMN TB_DETAIL_INSEPECTION_ITEM_VALUE.LIST_CODE IS '목록코드';

COMMENT ON COLUMN TB_DETAIL_INSEPECTION_ITEM_VALUE.LIST_ITEM IS '항목';

COMMENT ON TABLE TB_DETAIL_INSEPECTION_ITEM_VALUE IS '상세검수 항목 값';

CREATE UNIQUE INDEX TB_DETAIL_INSEPECTION_ITEM_VALUE_PK ON TB_DETAIL_INSEPECTION_ITEM_VALUE
    ( LIST_CODE );

ALTER TABLE TB_DETAIL_INSEPECTION_ITEM_VALUE
    ADD CONSTRAINT TB_DETAIL_INSEPECTION_ITEM_VALUE_PK PRIMARY KEY ( LIST_CODE )
    USING INDEX TB_DETAIL_INSEPECTION_ITEM_VALUE_PK;


DROP TABLE TB_STOCK_PARTS;

CREATE TABLE TB_STOCK_PARTS
(
    STOCK_PARTS_CODE    NUMBER NOT NULL,
    SERIAL_CODE    NUMBER NOT NULL,
    PARTS_CODE    NUMBER NOT NULL,
    REMAINING_COUNT    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_STOCK_PARTS.STOCK_PARTS_CODE IS '재고별 보유 부품 코드';

COMMENT ON COLUMN TB_STOCK_PARTS.SERIAL_CODE IS '재고코드';

COMMENT ON COLUMN TB_STOCK_PARTS.PARTS_CODE IS '부품코드';

COMMENT ON COLUMN TB_STOCK_PARTS.REMAINING_COUNT IS '잔여개수';

COMMENT ON TABLE TB_STOCK_PARTS IS '재고별 보유 부품';

CREATE UNIQUE INDEX TB_STOCK_PARTS_PK ON TB_STOCK_PARTS
    ( STOCK_PARTS_CODE );

ALTER TABLE TB_STOCK_PARTS
    ADD CONSTRAINT TB_STOCK_PARTS_PK PRIMARY KEY ( STOCK_PARTS_CODE )
    USING INDEX TB_STOCK_PARTS_PK;


DROP TABLE TB_REQUIRED_PARTS_LIST;

CREATE TABLE TB_REQUIRED_PARTS_LIST
(
    PARTS_CODE    NUMBER NOT NULL,
    BOARDGAME_TYPE_CODE    NUMBER NOT NULL,
    PARTS_NAME    VARCHAR2(60) NOT NULL,
    PARTS_COUNT    NUMBER
);

COMMENT ON COLUMN TB_REQUIRED_PARTS_LIST.PARTS_CODE IS '부품코드';

COMMENT ON COLUMN TB_REQUIRED_PARTS_LIST.BOARDGAME_TYPE_CODE IS '보드게임 종류 코드';

COMMENT ON COLUMN TB_REQUIRED_PARTS_LIST.PARTS_NAME IS '부품명';

COMMENT ON COLUMN TB_REQUIRED_PARTS_LIST.PARTS_COUNT IS '부품개수';

COMMENT ON TABLE TB_REQUIRED_PARTS_LIST IS '보드게임종류 별 필요한 부품 목록';

CREATE UNIQUE INDEX TB_REQUIRED_PARTS_LIST_PK ON TB_REQUIRED_PARTS_LIST
    ( PARTS_CODE );

ALTER TABLE TB_REQUIRED_PARTS_LIST
    ADD CONSTRAINT TB_REQUIRED_PARTS_LIST_PK PRIMARY KEY ( PARTS_CODE )
    USING INDEX TB_REQUIRED_PARTS_LIST_PK;


DROP TABLE TB_DETAIL_INSPECTION_CHECK_LIST;

CREATE TABLE TB_DETAIL_INSPECTION_CHECK_LIST
(
    LIST_CODE    NUMBER NOT NULL,
    BOARDGAME_TYPE_CODE    NUMBER NOT NULL,
    CHECK_CONTENT    VARCHAR2(300) NOT NULL
);

COMMENT ON COLUMN TB_DETAIL_INSPECTION_CHECK_LIST.LIST_CODE IS '목록코드';

COMMENT ON COLUMN TB_DETAIL_INSPECTION_CHECK_LIST.BOARDGAME_TYPE_CODE IS '보드게임 종류 코드';

COMMENT ON COLUMN TB_DETAIL_INSPECTION_CHECK_LIST.CHECK_CONTENT IS '체크 내용';

COMMENT ON TABLE TB_DETAIL_INSPECTION_CHECK_LIST IS '상세검수체크목록';

CREATE UNIQUE INDEX TB_DETAIL_INSPECTION_CHECK_LIST_PK ON TB_DETAIL_INSPECTION_CHECK_LIST
    ( LIST_CODE );

ALTER TABLE TB_DETAIL_INSPECTION_CHECK_LIST
    ADD CONSTRAINT TB_DETAIL_INSPECTION_CHECK_LIST_PK PRIMARY KEY ( LIST_CODE )
    USING INDEX TB_DETAIL_INSPECTION_CHECK_LIST_PK;


DROP TABLE TB_DELIVERY_ADDRESS;

CREATE TABLE TB_DELIVERY_ADDRESS
(
    ADDRESS_CODE    NUMBER NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL,
    ADDRESS_NAME    VARCHAR2(255) NOT NULL,
    ADDRESS_LOCATION    VARCHAR2(255) NOT NULL,
    ADDRESS_PHONE    VARCHAR2(20) NOT NULL,
    DELIVERY_RECIPIENT    VARCHAR2(30) NOT NULL,
    DEFAULT_ADDRESS_YN    CHAR(1) DEFAULT 'N' NOT NULL,
    COMMON_ENTRANCE_ACCESS_NUMBER_YN    CHAR(1) DEFAULT 'N' NOT NULL,
    COMMON_ENTRANCE_ACCESS_NUMBER    VARCHAR2(30),
    DELIVERY_LOCATION    VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.ADDRESS_CODE IS '배송지코드';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.MEMBER_CODE IS '회원코드';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.ADDRESS_NAME IS '배송지이름';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.ADDRESS_LOCATION IS '배송지주소';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.ADDRESS_PHONE IS '배송지휴대폰번호';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.DELIVERY_RECIPIENT IS '받는사람';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.DEFAULT_ADDRESS_YN IS '기본배송지여부';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.COMMON_ENTRANCE_ACCESS_NUMBER_YN IS '공동현관출입번호여부';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.COMMON_ENTRANCE_ACCESS_NUMBER IS '공동현관출입번호';

COMMENT ON COLUMN TB_DELIVERY_ADDRESS.DELIVERY_LOCATION IS '배송위치';

COMMENT ON TABLE TB_DELIVERY_ADDRESS IS '배송지';

CREATE UNIQUE INDEX TB_DELIVERY_ADDRESS_PK ON TB_DELIVERY_ADDRESS
    ( ADDRESS_CODE );

ALTER TABLE TB_DELIVERY_ADDRESS
    ADD CONSTRAINT TB_DELIVERY_ADDRESS_PK PRIMARY KEY ( ADDRESS_CODE )
    USING INDEX TB_DELIVERY_ADDRESS_PK;


DROP TABLE TB_PAYMENT_CANCELLATION_REASON;

CREATE TABLE TB_PAYMENT_CANCELLATION_REASON
(
    PAYMENT_CANCELLATION_REASON_CODE    VARCHAR2(20) NOT NULL,
    PAYMENT_CANCELLATION_REASON    VARCHAR2(500) NOT NULL
);

COMMENT ON COLUMN TB_PAYMENT_CANCELLATION_REASON.PAYMENT_CANCELLATION_REASON_CODE IS '결제 취소 사유코드';

COMMENT ON COLUMN TB_PAYMENT_CANCELLATION_REASON.PAYMENT_CANCELLATION_REASON IS '결제 취소 사유';

COMMENT ON TABLE TB_PAYMENT_CANCELLATION_REASON IS '결제 취소 사유';

CREATE UNIQUE INDEX TB_PAYMENT_CANCELLATION_REASON_PK ON TB_PAYMENT_CANCELLATION_REASON
    ( PAYMENT_CANCELLATION_REASON_CODE );

ALTER TABLE TB_PAYMENT_CANCELLATION_REASON
    ADD CONSTRAINT TB_PAYMENT_CANCELLATION_REASON_PK PRIMARY KEY ( PAYMENT_CANCELLATION_REASON_CODE )
    USING INDEX TB_PAYMENT_CANCELLATION_REASON_PK;


DROP TABLE TB_BOARDGAME_RATE;

CREATE TABLE TB_BOARDGAME_RATE
(
    RATING_CODE    VARCHAR2(20) NOT NULL,
    RATING    VARCHAR2(20) NOT NULL,
    RATE_DISCOUNT    NUMBER
);

COMMENT ON COLUMN TB_BOARDGAME_RATE.RATING_CODE IS '등급코드';

COMMENT ON COLUMN TB_BOARDGAME_RATE.RATING IS '등급';

COMMENT ON COLUMN TB_BOARDGAME_RATE.RATE_DISCOUNT IS '할인률';

COMMENT ON TABLE TB_BOARDGAME_RATE IS '보드게임 등급';

CREATE UNIQUE INDEX TB_BOARDGAME_RATE_PK ON TB_BOARDGAME_RATE
    ( RATING_CODE );

ALTER TABLE TB_BOARDGAME_RATE
    ADD CONSTRAINT TB_BOARDGAME_RATE_PK PRIMARY KEY ( RATING_CODE )
    USING INDEX TB_BOARDGAME_RATE_PK;


DROP TABLE TB_PAYMENT_STATUS_CHANGE_HISTORY;

CREATE TABLE TB_PAYMENT_STATUS_CHANGE_HISTORY
(
    PAYMENT_STATUS_CHANGE_HISTORY_CODE    VARCHAR2(20) NOT NULL,
    PAYMENT_CODE    VARCHAR2(20) NOT NULL,
    STATUS_CHANGE_DAY    VARCHAR2(20) NOT NULL,
    PAYMENT_STATUS    VARCHAR2(5) NOT NULL,
    PAYMENT_CANCELLATION_REASON_CODE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_PAYMENT_STATUS_CHANGE_HISTORY.PAYMENT_STATUS_CHANGE_HISTORY_CODE IS '결제 상태 변경 이력 코드';

COMMENT ON COLUMN TB_PAYMENT_STATUS_CHANGE_HISTORY.PAYMENT_CODE IS '결제코드';

COMMENT ON COLUMN TB_PAYMENT_STATUS_CHANGE_HISTORY.STATUS_CHANGE_DAY IS '상태 변경 날짜';

COMMENT ON COLUMN TB_PAYMENT_STATUS_CHANGE_HISTORY.PAYMENT_STATUS IS '결제 상태';

COMMENT ON COLUMN TB_PAYMENT_STATUS_CHANGE_HISTORY.PAYMENT_CANCELLATION_REASON_CODE IS '결제 취소 사유코드';

COMMENT ON TABLE TB_PAYMENT_STATUS_CHANGE_HISTORY IS '결제 상태 변경 이력';

CREATE UNIQUE INDEX TB_PAYMENT_STATUS_CHANGE_HISTORY_PK ON TB_PAYMENT_STATUS_CHANGE_HISTORY
    ( PAYMENT_STATUS_CHANGE_HISTORY_CODE );

ALTER TABLE TB_PAYMENT_STATUS_CHANGE_HISTORY
    ADD CONSTRAINT TB_PAYMENT_STATUS_CHANGE_HISTORY_PK PRIMARY KEY ( PAYMENT_STATUS_CHANGE_HISTORY_CODE )
    USING INDEX TB_PAYMENT_STATUS_CHANGE_HISTORY_PK;


DROP TABLE TB_POINT_CHANGE;

CREATE TABLE TB_POINT_CHANGE
(
    CHANGE_CODE    VARCHAR2(20) NOT NULL,
    REASON_CHANGE    VARCHAR2(300) NOT NULL,
    POINT_CHANGE_CODE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_POINT_CHANGE.CHANGE_CODE IS '변경코드';

COMMENT ON COLUMN TB_POINT_CHANGE.REASON_CHANGE IS '변경사유';

COMMENT ON COLUMN TB_POINT_CHANGE.POINT_CHANGE_CODE IS '코드구분';

COMMENT ON TABLE TB_POINT_CHANGE IS '포인트변경';

CREATE UNIQUE INDEX TB_POINT_CHANGE_PK ON TB_POINT_CHANGE
    ( CHANGE_CODE );

ALTER TABLE TB_POINT_CHANGE
    ADD CONSTRAINT TB_POINT_CHANGE_PK PRIMARY KEY ( CHANGE_CODE )
    USING INDEX TB_POINT_CHANGE_PK;


DROP TABLE TB_POINT_CHANGE_HISTORY;

CREATE TABLE TB_POINT_CHANGE_HISTORY
(
    CHANGE_HISTORY_CODE    VARCHAR2(20) NOT NULL,
    CHANGE_CODE    VARCHAR2(20) NOT NULL,
    USE_DATE    VARCHAR2(20) NOT NULL,
    AMOUNT_USED    NUMBER NOT NULL,
    PAYMENT_CODE    VARCHAR2(20) NOT NULL,
    CLASSIFICATION_CHANGES    VARCHAR2(20) NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.CHANGE_HISTORY_CODE IS '변경이력코드';

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.CHANGE_CODE IS '변경코드';

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.USE_DATE IS '사용일시';

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.AMOUNT_USED IS '사용금액';

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.PAYMENT_CODE IS '결제코드';

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.CLASSIFICATION_CHANGES IS '이력구분';

COMMENT ON COLUMN TB_POINT_CHANGE_HISTORY.MEMBER_CODE IS '회원코드';

COMMENT ON TABLE TB_POINT_CHANGE_HISTORY IS '포인트변경이력';

CREATE UNIQUE INDEX TB_POINT_CHANGE_HISTORY_PK ON TB_POINT_CHANGE_HISTORY
    ( CHANGE_HISTORY_CODE );

ALTER TABLE TB_POINT_CHANGE_HISTORY
    ADD CONSTRAINT TB_POINT_CHANGE_HISTORY_PK PRIMARY KEY ( CHANGE_HISTORY_CODE )
    USING INDEX TB_POINT_CHANGE_HISTORY_PK;


DROP TABLE TB_ORDER;

CREATE TABLE TB_ORDER
(
    ORDER_CODE    VARCHAR2(20) NOT NULL,
    ORDER_AMOUNT    NUMBER NOT NULL,
    COUPON_USED_AMOUNT    NUMBER NOT NULL,
    POINTS_USED_AMOUNT    NUMBER NOT NULL,
    ORDER_DATE    VARCHAR2(20) NOT NULL,
    WHETHER_PAY    VARCHAR2(5),
    SELECTED_PRODUCT    NUMBER DEFAULT 0 NOT NULL
);

COMMENT ON COLUMN TB_ORDER.ORDER_CODE IS '주문코드';

COMMENT ON COLUMN TB_ORDER.ORDER_AMOUNT IS '주문금액';

COMMENT ON COLUMN TB_ORDER.COUPON_USED_AMOUNT IS '쿠폰사용금액';

COMMENT ON COLUMN TB_ORDER.POINTS_USED_AMOUNT IS '포인트사용금액';

COMMENT ON COLUMN TB_ORDER.ORDER_DATE IS '주문일시';

COMMENT ON COLUMN TB_ORDER.WHETHER_PAY IS '결제여부';

COMMENT ON COLUMN TB_ORDER.SELECTED_PRODUCT IS '선택한상품의개수';

COMMENT ON TABLE TB_ORDER IS '주문';

CREATE UNIQUE INDEX TB_ORDER_PK ON TB_ORDER
    ( ORDER_CODE );

ALTER TABLE TB_ORDER
    ADD CONSTRAINT TB_ORDER_PK PRIMARY KEY ( ORDER_CODE )
    USING INDEX TB_ORDER_PK;


DROP TABLE TB_TERMS;

CREATE TABLE TB_TERMS
(
    TERMS_CODE    VARCHAR2(20) NOT NULL,
    TERMS_CONTENT    VARCHAR2(1000) NOT NULL,
    EXPIRATION_PERIOD    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_TERMS.TERMS_CODE IS '약관코드';

COMMENT ON COLUMN TB_TERMS.TERMS_CONTENT IS '약관내용';

COMMENT ON COLUMN TB_TERMS.EXPIRATION_PERIOD IS '만료기간';

COMMENT ON TABLE TB_TERMS IS '약관';

CREATE UNIQUE INDEX TB_TERMS_PK ON TB_TERMS
    ( TERMS_CODE );

ALTER TABLE TB_TERMS
    ADD CONSTRAINT TB_TERMS_PK PRIMARY KEY ( TERMS_CODE )
    USING INDEX TB_TERMS_PK;


DROP TABLE TB_TERMS_AGREEMENT;

CREATE TABLE TB_TERMS_AGREEMENT
(
    TERMS_AGREEMENT_CODE    VARCHAR2(20) NOT NULL,
    TERMS_CODE    VARCHAR2(20) NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL,
    AGREEMENT    VARCHAR2(5) NOT NULL,
    DATE_AGREEMENT    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_TERMS_AGREEMENT.TERMS_AGREEMENT_CODE IS '약관 동의 코드';

COMMENT ON COLUMN TB_TERMS_AGREEMENT.TERMS_CODE IS '약관코드';

COMMENT ON COLUMN TB_TERMS_AGREEMENT.MEMBER_CODE IS '회원코드';

COMMENT ON COLUMN TB_TERMS_AGREEMENT.AGREEMENT IS '동의여부';

COMMENT ON COLUMN TB_TERMS_AGREEMENT.DATE_AGREEMENT IS '동의한 일자';

COMMENT ON TABLE TB_TERMS_AGREEMENT IS '약관동의';

CREATE UNIQUE INDEX TB_TERMS_AGREEMENT_PK ON TB_TERMS_AGREEMENT
    ( TERMS_AGREEMENT_CODE );

ALTER TABLE TB_TERMS_AGREEMENT
    ADD CONSTRAINT TB_TERMS_AGREEMENT_PK PRIMARY KEY ( TERMS_AGREEMENT_CODE )
    USING INDEX TB_TERMS_AGREEMENT_PK;


DROP TABLE TB_STATISTICS_BOARDGAME_CATEGORY;

CREATE TABLE TB_STATISTICS_BOARDGAME_CATEGORY
(
    DATA_COLLECTION_DATE    VARCHAR2(20) NOT NULL,
    BOARDGAME_CATEGORY_CODE    VARCHAR2(20) NOT NULL,
    BOARDGAME_RENTAL_COUNT    NUMBER,
    BOARDGAME_SALES    NUMBER
);

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_CATEGORY.DATA_COLLECTION_DATE IS '데이터 수집 날짜';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_CATEGORY.BOARDGAME_CATEGORY_CODE IS '보드게임 상태';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_CATEGORY.BOARDGAME_RENTAL_COUNT IS '보드게임 대여 횟수';

COMMENT ON COLUMN TB_STATISTICS_BOARDGAME_CATEGORY.BOARDGAME_SALES IS '보드게임 매출액';

COMMENT ON TABLE TB_STATISTICS_BOARDGAME_CATEGORY IS '보드게임 카테고리 별 통계';

CREATE UNIQUE INDEX TB_STATISTICS_BOARDGAME_CATEGORY_PK ON TB_STATISTICS_BOARDGAME_CATEGORY
    ( DATA_COLLECTION_DATE );

ALTER TABLE TB_STATISTICS_BOARDGAME_CATEGORY
    ADD CONSTRAINT TB_STATISTICS_BOARDGAME_CATEGORY_PK PRIMARY KEY ( DATA_COLLECTION_DATE )
    USING INDEX TB_STATISTICS_BOARDGAME_CATEGORY_PK;


DROP TABLE TB_FAQ;

CREATE TABLE TB_FAQ
(
    FAQ_NO    NUMBER NOT NULL,
    FAQ_CALSS    VARCHAR2(60) NOT NULL,
    QUESTIONS    VARCHAR2(900) NOT NULL,
    ANSWER    VARCHAR2(900) NOT NULL,
    FAQ_HIT    NUMBER NOT NULL,
    ADMIN_NO    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_FAQ.FAQ_NO IS '게시글번호';

COMMENT ON COLUMN TB_FAQ.FAQ_CALSS IS '분류';

COMMENT ON COLUMN TB_FAQ.QUESTIONS IS '질문내용';

COMMENT ON COLUMN TB_FAQ.ANSWER IS '답변내용';

COMMENT ON COLUMN TB_FAQ.FAQ_HIT IS '조회수';

COMMENT ON COLUMN TB_FAQ.ADMIN_NO IS '관리자번호';

COMMENT ON TABLE TB_FAQ IS 'FAQ';

CREATE UNIQUE INDEX TB_FAQ_PK ON TB_FAQ
    ( FAQ_NO );

ALTER TABLE TB_FAQ
    ADD CONSTRAINT TB_FAQ_PK PRIMARY KEY ( FAQ_NO )
    USING INDEX TB_FAQ_PK;


DROP TABLE TB_NOTICE;

CREATE TABLE TB_NOTICE
(
    BOARD_NO    NUMBER NOT NULL,
    BOARD_TITLE    VARCHAR2(300) NOT NULL,
    BOARD_CONTENT    VARCHAR2(2000) NOT NULL,
    WRITE_DATE    VARCHAR2(30) NOT NULL,
    BOARD_HIT    NUMBER NOT NULL,
    FILE_PATH    VARCHAR2(300),
    ADMIN_NO    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_NOTICE.BOARD_NO IS '게시판번호';

COMMENT ON COLUMN TB_NOTICE.BOARD_TITLE IS '제목';

COMMENT ON COLUMN TB_NOTICE.BOARD_CONTENT IS '내용';

COMMENT ON COLUMN TB_NOTICE.WRITE_DATE IS '작성일자';

COMMENT ON COLUMN TB_NOTICE.BOARD_HIT IS '조회수';

COMMENT ON COLUMN TB_NOTICE.FILE_PATH IS '파일경로';

COMMENT ON COLUMN TB_NOTICE.ADMIN_NO IS '관리자번호';

COMMENT ON TABLE TB_NOTICE IS '공지사항';

CREATE UNIQUE INDEX TB_NOTICE_PK ON TB_NOTICE
    ( BOARD_NO );

ALTER TABLE TB_NOTICE
    ADD CONSTRAINT TB_NOTICE_PK PRIMARY KEY ( BOARD_NO )
    USING INDEX TB_NOTICE_PK;


DROP TABLE TB_MANAGER;

CREATE TABLE TB_MANAGER
(
    ADMIN_NO    NUMBER NOT NULL,
    ADMIN_ID    VARCHAR2(60) NOT NULL,
    ADMIN_PWD    VARCHAR2(60) NOT NULL,
    MEMBER_ROLE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_MANAGER.ADMIN_NO IS '관리자번호';

COMMENT ON COLUMN TB_MANAGER.ADMIN_ID IS '관리자아이디';

COMMENT ON COLUMN TB_MANAGER.ADMIN_PWD IS '관리자비밀번호';

COMMENT ON COLUMN TB_MANAGER.MEMBER_ROLE IS '회원권한';

COMMENT ON TABLE TB_MANAGER IS '관리자';

CREATE UNIQUE INDEX TB_MANAGER_PK ON TB_MANAGER
    ( ADMIN_NO );

ALTER TABLE TB_MANAGER
    ADD CONSTRAINT TB_MANAGER_PK PRIMARY KEY ( ADMIN_NO )
    USING INDEX TB_MANAGER_PK;


DROP TABLE TB_COUPON_STATUS_CHANGE_HISTORY;

CREATE TABLE TB_COUPON_STATUS_CHANGE_HISTORY
(
    STATUS_CHANGE_CODE    NUMBER NOT NULL,
    HOLD_COUPON_CODE    NUMBER NOT NULL,
    CHANGE_DATE    VARCHAR2(30) NOT NULL,
    PAYMEMT_CODE    NUMBER NOT NULL,
    CHANGE_STATUS    VARCHAR2(30)
);

COMMENT ON COLUMN TB_COUPON_STATUS_CHANGE_HISTORY.STATUS_CHANGE_CODE IS '쿠폰 상태 변경 코드';

COMMENT ON COLUMN TB_COUPON_STATUS_CHANGE_HISTORY.HOLD_COUPON_CODE IS '보유쿠폰코드';

COMMENT ON COLUMN TB_COUPON_STATUS_CHANGE_HISTORY.CHANGE_DATE IS '일자';

COMMENT ON COLUMN TB_COUPON_STATUS_CHANGE_HISTORY.PAYMEMT_CODE IS '결제코드';

COMMENT ON COLUMN TB_COUPON_STATUS_CHANGE_HISTORY.CHANGE_STATUS IS '변경 쿠폰 상태';

COMMENT ON TABLE TB_COUPON_STATUS_CHANGE_HISTORY IS '쿠폰 상태 변경 이력';

CREATE UNIQUE INDEX TB_COUPON_STATUS_CHANGE_HISTORY_PK ON TB_COUPON_STATUS_CHANGE_HISTORY
    ( STATUS_CHANGE_CODE );

ALTER TABLE TB_COUPON_STATUS_CHANGE_HISTORY
    ADD CONSTRAINT TB_COUPON_STATUS_CHANGE_HISTORY_PK PRIMARY KEY ( STATUS_CHANGE_CODE )
    USING INDEX TB_COUPON_STATUS_CHANGE_HISTORY_PK;


DROP TABLE TB_COUPON;

CREATE TABLE TB_COUPON
(
    COUPON_CODE    NUMBER NOT NULL,
    COUPON_NAME    VARCHAR2(60) NOT NULL,
    EXPLANATION    VARCHAR2(600) NOT NULL,
    EXPIRATION_PERIOD    VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN TB_COUPON.COUPON_CODE IS '쿠폰코드';

COMMENT ON COLUMN TB_COUPON.COUPON_NAME IS '쿠폰이름';

COMMENT ON COLUMN TB_COUPON.EXPLANATION IS '쿠폰설명';

COMMENT ON COLUMN TB_COUPON.EXPIRATION_PERIOD IS '유효기간';

COMMENT ON TABLE TB_COUPON IS '쿠폰';

CREATE UNIQUE INDEX TB_COUPON_PK ON TB_COUPON
    ( COUPON_CODE );

ALTER TABLE TB_COUPON
    ADD CONSTRAINT TB_COUPON_PK PRIMARY KEY ( COUPON_CODE )
    USING INDEX TB_COUPON_PK;


DROP TABLE TB_HOLDING_COUPONS;

CREATE TABLE TB_HOLDING_COUPONS
(
    HOLD_COUPON_CODE    NUMBER NOT NULL,
    COUPON_CODE    NUMBER NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL,
    ISSUE_DATE    VARCHAR2(30) NOT NULL,
    EXPIRATION_DATE    VARCHAR2(30) NOT NULL,
    EXPIRATION    CHAR(1) NOT NULL,
    COUPON_STATUS    VARCHAR2(30)
);

COMMENT ON COLUMN TB_HOLDING_COUPONS.HOLD_COUPON_CODE IS '보유쿠폰코드';

COMMENT ON COLUMN TB_HOLDING_COUPONS.COUPON_CODE IS '쿠폰코드';

COMMENT ON COLUMN TB_HOLDING_COUPONS.MEMBER_CODE IS '회원코드';

COMMENT ON COLUMN TB_HOLDING_COUPONS.ISSUE_DATE IS '발급일자';

COMMENT ON COLUMN TB_HOLDING_COUPONS.EXPIRATION_DATE IS '만료일자';

COMMENT ON COLUMN TB_HOLDING_COUPONS.EXPIRATION IS '만료여부';

COMMENT ON COLUMN TB_HOLDING_COUPONS.COUPON_STATUS IS '쿠폰 상태';

COMMENT ON TABLE TB_HOLDING_COUPONS IS '보유쿠폰';

CREATE UNIQUE INDEX TB_HOLDING_COUPONS_PK ON TB_HOLDING_COUPONS
    ( HOLD_COUPON_CODE );

ALTER TABLE TB_HOLDING_COUPONS
    ADD CONSTRAINT TB_HOLDING_COUPONS_PK PRIMARY KEY ( HOLD_COUPON_CODE )
    USING INDEX TB_HOLDING_COUPONS_PK;


DROP TABLE TB_WARNING;

CREATE TABLE TB_WARNING
(
    WARNING_CODE    NUMBER NOT NULL,
    REASON_FOR_WARNING    VARCHAR2(600) NOT NULL
);

COMMENT ON COLUMN TB_WARNING.WARNING_CODE IS '경고코드';

COMMENT ON COLUMN TB_WARNING.REASON_FOR_WARNING IS '경고사유';

COMMENT ON TABLE TB_WARNING IS '경고';

CREATE UNIQUE INDEX TB_WARNING_PK ON TB_WARNING
    ( WARNING_CODE );

ALTER TABLE TB_WARNING
    ADD CONSTRAINT TB_WARNING_PK PRIMARY KEY ( WARNING_CODE )
    USING INDEX TB_WARNING_PK;


DROP TABLE TB_WARNING_HISTORY;

CREATE TABLE TB_WARNING_HISTORY
(
    WARNING_HISTORY_CODE    NUMBER NOT NULL,
    WARNING_DATE    VARCHAR2(30) NOT NULL,
    WARNING_MEMBER_CODE    NUMBER NOT NULL,
    WARNING_CODE    NUMBER NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_WARNING_HISTORY.WARNING_HISTORY_CODE IS '경고이력코드';

COMMENT ON COLUMN TB_WARNING_HISTORY.WARNING_DATE IS '경고날짜';

COMMENT ON COLUMN TB_WARNING_HISTORY.WARNING_MEMBER_CODE IS '경고 대상자 회원코드';

COMMENT ON COLUMN TB_WARNING_HISTORY.WARNING_CODE IS '경고코드';

COMMENT ON COLUMN TB_WARNING_HISTORY.MEMBER_CODE IS '회원코드';

COMMENT ON TABLE TB_WARNING_HISTORY IS '경고이력';

CREATE UNIQUE INDEX TB_WARNING_HISTORY_PK ON TB_WARNING_HISTORY
    ( WARNING_HISTORY_CODE );

ALTER TABLE TB_WARNING_HISTORY
    ADD CONSTRAINT TB_WARNING_HISTORY_PK PRIMARY KEY ( WARNING_HISTORY_CODE )
    USING INDEX TB_WARNING_HISTORY_PK;


DROP TABLE TB_BLACKLIST;

CREATE TABLE TB_BLACKLIST
(
    BLACKLIST    NUMBER NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL,
    REGISTRATION_DATE    VARCHAR2(30) NOT NULL,
    TERMINATION_DATE    VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN TB_BLACKLIST.BLACKLIST IS '블랙리스트 코드';

COMMENT ON COLUMN TB_BLACKLIST.MEMBER_CODE IS '회원코드';

COMMENT ON COLUMN TB_BLACKLIST.REGISTRATION_DATE IS '등록날짜';

COMMENT ON COLUMN TB_BLACKLIST.TERMINATION_DATE IS '해지날짜';

COMMENT ON TABLE TB_BLACKLIST IS '블랙리스트';

CREATE UNIQUE INDEX TB_BLACKLIST_PK ON TB_BLACKLIST
    ( BLACKLIST );

ALTER TABLE TB_BLACKLIST
    ADD CONSTRAINT TB_BLACKLIST_PK PRIMARY KEY ( BLACKLIST )
    USING INDEX TB_BLACKLIST_PK;


DROP TABLE TB_LOGIN_FAILURE_HISTORY;

CREATE TABLE TB_LOGIN_FAILURE_HISTORY
(
    FAILURE_CODE    NUMBER NOT NULL,
    FAILURE_TIME    VARCHAR2(30) NOT NULL,
    IP    VARCHAR2(60) NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_LOGIN_FAILURE_HISTORY.FAILURE_CODE IS '실패코드';

COMMENT ON COLUMN TB_LOGIN_FAILURE_HISTORY.FAILURE_TIME IS '실패시간';

COMMENT ON COLUMN TB_LOGIN_FAILURE_HISTORY.IP IS 'IP';

COMMENT ON COLUMN TB_LOGIN_FAILURE_HISTORY.MEMBER_CODE IS '회원코드';

COMMENT ON TABLE TB_LOGIN_FAILURE_HISTORY IS '로그인실패이력';

CREATE UNIQUE INDEX TB_LOGIN_FAILURE_HISTORY_PK ON TB_LOGIN_FAILURE_HISTORY
    ( FAILURE_CODE );

ALTER TABLE TB_LOGIN_FAILURE_HISTORY
    ADD CONSTRAINT TB_LOGIN_FAILURE_HISTORY_PK PRIMARY KEY ( FAILURE_CODE )
    USING INDEX TB_LOGIN_FAILURE_HISTORY_PK;


DROP TABLE TB_LOGIN_SUCCESS_HISTORY;

CREATE TABLE TB_LOGIN_SUCCESS_HISTORY
(
    SUCCESS_CODE    NUMBER NOT NULL,
    SUCCESS_TIME    VARCHAR2(30) NOT NULL,
    IP    VARCHAR2(60) NOT NULL,
    MEMBER_CODE    NUMBER NOT NULL
);

COMMENT ON COLUMN TB_LOGIN_SUCCESS_HISTORY.SUCCESS_CODE IS '성공코드';

COMMENT ON COLUMN TB_LOGIN_SUCCESS_HISTORY.SUCCESS_TIME IS '성공시간';

COMMENT ON COLUMN TB_LOGIN_SUCCESS_HISTORY.IP IS 'IP';

COMMENT ON COLUMN TB_LOGIN_SUCCESS_HISTORY.MEMBER_CODE IS '회원코드';

COMMENT ON TABLE TB_LOGIN_SUCCESS_HISTORY IS '로그인성공이력';

CREATE UNIQUE INDEX TB_LOGIN_SUCCESS_HISTORY_PK ON TB_LOGIN_SUCCESS_HISTORY
    ( SUCCESS_CODE );

ALTER TABLE TB_LOGIN_SUCCESS_HISTORY
    ADD CONSTRAINT TB_LOGIN_SUCCESS_HISTORY_PK PRIMARY KEY ( SUCCESS_CODE )
    USING INDEX TB_LOGIN_SUCCESS_HISTORY_PK;


DROP TABLE TB_MEMBER;

CREATE TABLE TB_MEMBER
(
    MEMBER_CODE    NUMBER NOT NULL,
    MEMBER_ID    VARCHAR2(60) NOT NULL,
    MEMBER_PWD    VARCHAR2(60) NOT NULL,
    MEMBER_NAME    VARCHAR2(30) NOT NULL,
    EMAIL    VARCHAR2(90) NOT NULL,
    PHONE    VARCHAR2(90) NOT NULL,
    GENDER    VARCHAR2(10),
    JOB    VARCHAR2(60),
    BIRTH_DATE_TIME    VARCHAR2(30),
    LOGIN_LOCK    CHAR(1),
    JOIN_DATE    VARCHAR2(30),
    WITHDRAWAL_MEMBER    CHAR(1) NOT NULL,
    HOLDING_POINT    NUMBER NOT NULL,
    MEMBER_ROLE    VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN TB_MEMBER.MEMBER_CODE IS '회원코드';

COMMENT ON COLUMN TB_MEMBER.MEMBER_ID IS '아이디';

COMMENT ON COLUMN TB_MEMBER.MEMBER_PWD IS '비밀번호';

COMMENT ON COLUMN TB_MEMBER.MEMBER_NAME IS '이름';

COMMENT ON COLUMN TB_MEMBER.EMAIL IS '이메일';

COMMENT ON COLUMN TB_MEMBER.PHONE IS '전화번호';

COMMENT ON COLUMN TB_MEMBER.GENDER IS '성별';

COMMENT ON COLUMN TB_MEMBER.JOB IS '직업';

COMMENT ON COLUMN TB_MEMBER.BIRTH_DATE_TIME IS '생년월일';

COMMENT ON COLUMN TB_MEMBER.LOGIN_LOCK IS '로그인잠금';

COMMENT ON COLUMN TB_MEMBER.JOIN_DATE IS '가입날짜';

COMMENT ON COLUMN TB_MEMBER.WITHDRAWAL_MEMBER IS '탈퇴회원';

COMMENT ON COLUMN TB_MEMBER.HOLDING_POINT IS '보유포인트';

COMMENT ON COLUMN TB_MEMBER.MEMBER_ROLE IS '회원권한';

COMMENT ON TABLE TB_MEMBER IS '회원';

CREATE UNIQUE INDEX TB_MEMBER_PK ON TB_MEMBER
    ( MEMBER_CODE );

ALTER TABLE TB_MEMBER
    ADD CONSTRAINT TB_MEMBER_PK PRIMARY KEY ( MEMBER_CODE )
    USING INDEX TB_MEMBER_PK;

DROP TABLE TB_BOARDGAME_CATEGORY;
CREATE TABLE TB_BOARDGAME_CATEGORY
(
    BOARDGAME_CATEGORY_CODE    NUMBER NOT NULL,
    CATEGORY_NAME    VARCHAR2(30) NOT NULL
);

COMMIT;