Важным аспектом для любой локальной вычислительной сети является обеспечение её защитой от внешних угроз. Для этого реализуется политика безопасности, которая представляет из себя набор правил и ограничений. 

Для реализации сетевой политики организации были настроены следующие технологии
1.	Разбиение сети на VLAN с помощью VLSM в соответствии с отделами организации
VLAN представляет собой метод логического разбиения физической сети на несколько виртуальных локальных сетей (логических сегментов). Каждый VLAN имеет свой собственный идентификатор и может включать в себя различные порты коммутатора
2.	Обеспечение доступа к внутренним и внешним ресурсам компании с использованием протоколов безопасности и антивирусного программного обеспечения
3.	Использование технологии Pat для обеспечения доступа в Интернет
PAT – технология трансляции адресов с использованием портов, позволяет локальным хостам использовать частные IP-адреса и установить один зарегистрированный адрес на маршрутизатор доступа.
4.	Разграничение прав доступа к ресурсам сети с помощью Access List
ACL – набор текстовых правил, которые что-либо разрешают, либо запрещают.
5.	Защита портов коммутатора с помощью Port Security
Port-Security – это функция коммутатора, при помощи которой мы можем указать каким устройствам можно пропускать трафик через определенные порты.
6.	Агрегации каналов с помощью EtherChannel
Etherchannel — это технология, позволяющая объединять (агрегировать) несколько физических проводов (каналов, портов) в единый логический интерфейс. Используется для повышения отказоустойчивости и увеличения пропускной способности канала.
7.	Защита от петель с помощью протокола RSTP
RSTP – версия протокола STP c ускоренной реконфигурацией дерева, использующегося для исключения петель (исключения дублирующих маршрутов) в соединениях коммутаторов Ethernet с дублирующими линиями.
8.	Использование технологии PortFast 
PortFast – технология, которая позволяет порту пропустить состояния listening и learning и сразу же перейти в состояние forwarding.
9.	Использование технологии BPDU Guard 
BPDU Guard-это функция, которая защищает топологию протокола связующего дерева уровня 2 (STP) от угроз, связанных с BPDU, и предназначена для защиты коммутационной сети.
10.	Использование средств для удалённого подключения к сетевому оборудованию с помощью SSH
SSH –сетевой протокол прикладного уровня, позволяющий производить удалённое управление.
11.	Использование DHCP snooping для защиты от подмены DHCP-сервера
DHCP snooping – технология безопасности уровня 2, встроенная в операционную систему работоспособного сетевого коммутатора, которая отбрасывает трафик DHCP, определенный как неприемлемый.
12.	Мониторинг сети с помощью Syslog
Syslog – стандарт отправки и регистрации сообщений о происходящих в системе событиях
13.	Использование протокола WPA2 с алгоритмом шифрования AES для подключения устройств посредством Wi-Fi
WPA2 – технология защиты беспроводного соединения, пришедшая на смену устаревшему стандарту WEP
AES – Симметричный алгоритм блочного шифрования.

Для реализации сетевой политики использовалась программа Cisco Packet Tracer.
