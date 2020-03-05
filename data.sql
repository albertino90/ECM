INSERT INTO `ecm_schema`.`organizations` (`id`, `address`, `legal_address`, `name`) VALUES ('1', 'ул Мира 8', 'ул Первомайская 16', 'Рога и Копыта');
INSERT INTO `ecm_schema`.`organizations` (`id`, `address`, `legal_address`, `name`) VALUES ('2', 'ул Карла Макрса 10', 'ул Пушкина 45', 'Шараж-Монтаж');

INSERT INTO `ecm_schema`.`structural_units` (`id`, `email`, `name`, `organization__id`) VALUES ('1', 'itroga@mail.ru', 'it отдел', '1');
INSERT INTO `ecm_schema`.`structural_units` (`email`, `name`, `organization__id`) VALUES ('hrroga@mail.ru', 'hr отдел', '1');
INSERT INTO `ecm_schema`.`structural_units` (`email`, `name`, `organization__id`) VALUES ('montaj@yandex.ru', 'бухгалтерия', '2');

INSERT INTO `ecm_schema`.`employees` (`id`, `first_name`, `last_name`, `middle_name`, `position`, `structural_unit_id`) VALUES ('1', 'Иван', 'Крузенштерн', 'Федорович', 'Директор', '1');
