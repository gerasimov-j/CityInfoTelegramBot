INSERT
    country(id, name, emoji_code) VALUES
    (1, 'Беларусь', ':by:'),
    (2, 'Россия', ':ru:'),
    (3, 'Украина', ':ua:'),
    (4, 'Ватикан', ':va:'),
    (5, 'Литва', ':lt:'),
    (6, 'Италия', ':it:'),
    (7, 'США', ':us:'),
    (8, 'Китай', ':cn:'),
    (9, 'Австралия', ':au:'),
    (10, 'Бразилия', ':br:'),
    (11, 'Израиль', ':il:'),
    (12, 'Франция', ':fr:')
    on duplicate key update name = values(name), emoji_code = values(emoji_code);