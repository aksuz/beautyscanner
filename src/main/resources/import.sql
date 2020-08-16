DROP schema beautyscanner;
CREATE schema beautyscanner;
 
INSERT into category (id_category, category_name) VALUES (1, 'WLOSY');
INSERT into category (id_category, category_name) VALUES (2, 'TWARZ');
INSERT into category (id_category, category_name) VALUES (3, 'CIALO');
INSERT into category (id_category, category_name) VALUES (4, 'MAKIJAZ');
INSERT into category (id_category, category_name) VALUES (5, 'PAZNOKCIE');

INSERT into country (id_country, country_name) VALUES (1, 'POLSKA');
INSERT into country (id_country, country_name) VALUES (2, 'NIEMCY');
INSERT into country (id_country, country_name) VALUES (3, 'FRANCJA');
INSERT into country (id_country, country_name) VALUES (4, 'TURCJA');

INSERT into producer (id_producer, producer_name, country_id_id_country) VALUES (1, 'WELLA', 2);
INSERT into producer (id_producer, producer_name, country_id_id_country) VALUES (2, 'TOLPA', 1);
INSERT into producer (id_producer, producer_name, country_id_id_country) VALUES (3, 'LE PETIT MARSEILLAIS', 3);
INSERT into producer (id_producer, producer_name, country_id_id_country) VALUES (4, 'GOLDEN ROSE', 4);
INSERT into producer (id_producer, producer_name, country_id_id_country) VALUES (5, 'LOVLEY', 1);
INSERT into producer (id_producer, producer_name, country_id_id_country) VALUES (6, 'BIELENDA', 1);

INSERT into product (id_product, barcode, product_name, description, picture, url, producer_id_producer, category_id_category, no_rating_votes, sum_raining_votes)
VALUES (1, '4056800114047', 'Wellaflex, Flexible Ultra Strong Hairspray', 'Zapewnia bardzo mocne utrwalenie i elastyczność fryzury do 24 godzin.', null, 'https://static.wizaz.pl/media/cache/500x500/kwc/product/5/d/5d35f5be13aa6.jpeg', 1, 1, 1, 4);
INSERT into product (id_product, barcode, product_name, description, picture, url, producer_id_producer, category_id_category, no_rating_votes, sum_raining_votes)
VALUES (2, '5900950937072', 'Pump Up, tusz do rzęs', 'Niesamowicie podkręcająy.', null, 'https://image.ceneostatic.pl/data/products/48680162/i-wibo-mascara-tusz-do-rzes-pump-up-1-szt.jpg', 5, 4, 5, 21);
INSERT into product (id_product, barcode, product_name, description, picture, url, producer_id_producer, category_id_category, no_rating_votes, sum_raining_votes)
VALUES (3, '5907608614484', 'Sebio, normalizujący płyn micelarny', 'Codziennie zapobiega niedoskonałościom.', null, 'https://image.ceneostatic.pl/data/products/66928088/i-tolpa-sebio-normalizujacy-plyn-micelarny-do-mycia-twarzy-i-oczu-400-ml.jpg', 2, 2, 0, 0);
INSERT into product (id_product, barcode, product_name, description, picture, url, producer_id_producer, category_id_category, no_rating_votes, sum_raining_votes)
VALUES (4, '3574661271842', 'Żel pod prysznic i do kąpieli', 'Nawilża i odświeza. Biała brzoskwinia i nektarynka, delikatny.', null, 'https://image.ceneostatic.pl/data/products/30167130/i-le-petit-marseillais-zel-pod-prysznic-biala-brzoskwinia-nektarynka-250ml.jpg', 3, 3, 0, 0);
INSERT into product (id_product, barcode, product_name, description, picture, url, producer_id_producer, category_id_category, no_rating_votes, sum_raining_votes)
VALUES (5, '8691190419714', 'Extreme gel shine, lakier do paznokci', '65', null, 'https://www.wiadomoscihandlowe.pl/img/produkty/21900_0_zelowy-lakier-do-paznokci-golden-rose-extr_2.jpg', 4, 5, 0, 0);
INSERT into product (id_product, barcode, product_name, description, picture, url, producer_id_producer, category_id_category, no_rating_votes, sum_raining_votes)
VALUES (6, '5902169024277', 'Fluid matujący', 'Formuła przeciw błyszczeniu, jasny beż 01.', null, 'https://wizaz24.pl/image/7ws98x27hts7xcwzz8w2', 6, 4,1, 5);

INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (1, 'Dimethyl Ether', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (2, 'Alcohol Denat', 'https://wizaz.pl/kosmetyki/skladnik,462006,alcohol-denat.html', false, true, true, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (3, 'Octylacrylamide/Acrylates/Butylaminoethyl Methacrylate Copolymer', 'http://www.kosmopedia.org/encyklopedia/acrylates_copolymer,842/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (4, 'Aqua', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (5, 'Aminoethyl Propanol', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (6, 'PEG-12 Dimethicone', 'http://www.kosmopedia.org/encyklopedia/peg_12,825/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (7, 'Parfum', null, false, true, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (8, 'VP/VA Copolymer', 'http://www.kosmopedia.org/encyklopedia/acrylates_vp_copolymer,525/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (9, 'Isopropyl Alcohol', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (11, 'Acrylates/t-Butylacrylamide Copolymer', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (12, 'Linalool', 'http://www.kosmopedia.org/encyklopedia/linalool,371/', false, true, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (13, 'Triethyl Citrate', 'http://www.kosmopedia.org/encyklopedia/triethyl_citrate,1088/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (14, 'Hexyl Cinnamal', 'http://www.kosmopedia.org/encyklopedia/hexyl_cinnamal,374/', false, true, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (15, 'Citronellol', 'http://www.kosmopedia.org/encyklopedia/citronellol,373/', false, true, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (16, 'Limonene', 'http://www.kosmopedia.org/encyklopedia/limonene,375/', false, true, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (17, 'Benzyl Salicylate', 'http://www.kosmopedia.org/encyklopedia/benzyl_salicylate,365/', false, true, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (18, 'Cera Alba', 'http://www.kosmopedia.org/encyklopedia/cera_alba,833/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (19, 'Glyceryl Stearate', 'http://www.kosmopedia.org/encyklopedia/glyceryl_stearate,312/', false, false, false, true, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (20, 'Copernicia Cerifera Cera*', 'http://www.kosmopedia.org/encyklopedia/copernicia_cerifera_cera,855/', false, false, false, true, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (21, 'Propylene Glycol', 'http://www.kosmopedia.org/encyklopedia/propylene_glycol,342/', false, true, false, true, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (22, 'Candelilla Cera', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (23, 'Stearic Acid', 'http://www.kosmopedia.org/encyklopedia/stearic_acid,1075/', false, false, false, true, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (24, 'Polyvinyl Alcohol', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (25, 'PVP', 'http://www.kosmopedia.org/encyklopedia/pvp,984/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (26, 'Triethanolamine', 'http://www.kosmopedia.org/encyklopedia/triethanolamine,355/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (27, 'Palmitic Acid', 'http://www.kosmopedia.org/encyklopedia/palmitic_acid,932/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (28, 'Phenoxyethanol', 'http://www.kosmopedia.org/encyklopedia/phenoxyethanol,931/', false, true, false, false, false, true);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (29, 'Sodium Dehydroacetate', null, false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (30, 'Methylparaben', 'http://www.kosmopedia.org/encyklopedia/methylparaben,324/', false, true, false, false, false, true);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (31, 'Propylparaben', 'http://www.kosmopedia.org/encyklopedia/propylparaben,343/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (32, 'Lecithin', 'http://www.kosmopedia.org/encyklopedia/lecithin,465/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (33, 'Tocopherol', 'http://www.kosmopedia.org/encyklopedia/tocopherol,560/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (34, 'Ascorbyl Palmitate', 'http://www.kosmopedia.org/encyklopedia/ascorbyl_palmitate,556/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (35, 'Citric Acid', 'http://www.kosmopedia.org/encyklopedia/citric_acid,624/', false, false, false, false, false, false);
INSERT into ingredient (id_ingredient, ingredient_name, url, is_natural, is_allergen, is_irritant, is_comedogenic, is_carcinogenic, is_forbidden_during_pregnancy)
VALUES (36, 'CI 77499', null, false, false, false, false, false, false);

INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 1);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 2);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 3);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 4);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 5);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 6);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 7);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 8);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 9);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 11);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 12);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 13);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 14);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 15);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 16);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (1, 17);

INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 18);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 19);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 20);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 21);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 22);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 23);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 24);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 25);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 26);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 27);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 28);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 29);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 30);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 31);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 32);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 33);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 34);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 35);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 36);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 4);
INSERT into product_ingredient (product_id_product, ingredients_id_ingredient) VALUES (2, 8);

INSERT into user (id_user, nick, email, role) VALUES (1, 'ADMIN', 'admin@admin.pl', 'ADMIN');
INSERT into user (id_user, nick, email, role) VALUES (2, 'USER1', 'user1@gmail.com', 'USER');
INSERT into user (id_user, nick, email, role) VALUES (3, 'USER2', 'user2@gmail.com', 'USER');
INSERT into user (id_user, nick, email, role) VALUES (4, 'USER3', 'user3@gmail.com', 'USER');

INSERT into user_password (id_password, password, user_id_user) VALUES (1, 'admin1', 1);
INSERT into user_password (id_password, password, user_id_user) VALUES (2, 'user1', 2);
INSERT into user_password (id_password, password, user_id_user) VALUES (3, 'user2', 3);
INSERT into user_password (id_password, password, user_id_user) VALUES (4, 'user3', 4);

INSERT into user_allergen (id_user_allergen, user_id_user) VALUES (1, 2);
INSERT into user_allergens (user_allergen_id_user_allergen, allergens_id_ingredient) VALUES (1, 21);
INSERT into user_allergens (user_allergen_id_user_allergen, allergens_id_ingredient) VALUES (1, 28);
INSERT into user_allergens (user_allergen_id_user_allergen, allergens_id_ingredient) VALUES (1, 30);

INSERT into my_product (id_myproduct, product_id_id_product, expiration_time, opening_date, product_rating)
VALUES (1, 1, DATE_ADD(CURDATE(), INTERVAL 6 MONTH), CURDATE(), 4);
INSERT into my_product (id_myproduct, product_id_id_product, expiration_time, opening_date, product_rating)
VALUES (2, 6, DATE_ADD(CURDATE(), INTERVAL 6 MONTH), CURDATE(), 5);

INSERT into user_products (id_user_products, user_id_user) VALUES (1, 2);
INSERT into user_myproducts (user_id, my_product_id) VALUES (1, 1);
INSERT into user_myproducts (user_id, my_product_id) VALUES (1, 2);