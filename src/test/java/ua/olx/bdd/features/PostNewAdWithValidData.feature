Feature: Post new add with valid data

  As an OLX user
  I want to post new ad with valid details
  I want to be redirected on the confirmation page and see the reported ad details
  so that I know it has been posted successfully

  Scenario: Add ad with valid details
    Given I am on the homepage
    And I log in using the email 'shcherbyna.ira@gmail.com' and password 'password'
    When I navigate to the add advertisement page
    And enter valid information to the advertisement details fields
    | Title              | Category | Sub Category | Price | Breed       | Is Business | Description                                                                                                                                                                                                                                                                                                                                                                                                           |
    | Бенгальские котики | Животные | Кошки        | 10000 | Бенгальская | false       | Очаровательные котята, окрас : розетка на золоте (очень контрастные и яркие морфы). Забирать деток уже можно, подрастают котята к Николаю и Новому году. Котята от титулованных родителей, папа трех кратный чемпион, мама двух кратный. Котята, очень славные, толстенькие, сбитенькие, здоровенькие, игривые. Бенгалы сами по себе отличаются, добродушным и порядочным характером, чистоплотностью и ласковостью.  |
    And valid information to the contact details fields
    | address | region                 | district     | name  |
    | Киев    | Киев, Киевская область | Голосеевский | Ирина |
    And I submit the form
    Then I should see the confirmation page with successfully message
    And posted ad details