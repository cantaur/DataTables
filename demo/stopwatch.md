# stopwatch test

## CURRI_CONNECT -> tb_ma_curri_connect_test
### full data (4060120)

- reuse, mybatis foreach 1만개: 3971218
- transaction, batch 1만개 : 1877023
- transaction, batch, mybatis foreach 1만개 : 513566
- without transaction, batch, mybatis foreach 5만개: 377613
- transaction, batch, mybatis foreach 5만개 : 376815
- transaction, batch, mybatis foreach 5만개, MapStruct 이용 : 336535
- transaction, default, mybatis foreach 5만개, MapStruct 이용 : 339333
- transaction, reuse, mybatis foreach 5만개, MapStruct 이용 : 338986

