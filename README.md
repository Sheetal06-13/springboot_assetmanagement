# springboot_assetmanagement -A Springboot application based on RestAPI.
In this application I have created one to one mapping between asset and category of a product of company using Spring boot,jpa and mysql database.
You can see here 4 packages like controller,services,entity ,repository.
# In controller package 
I created two controller files like AssetController -which control asset CRUD operations of AssetServicesand another CategoryController which control category Crud operations.
here I used foreign key as a asset id so that i made connection between asset and category of a product.
# In services package -
I created two services files so that they provide services to controller.
# In entity package- 
I have created database tables like asset and category so that they story values for a particular fields.
# In application.properties-
I made a database connection using mysql as my h2 database is not working.
# In pom.xml file- 
I added dependency like jpa ,mysql and starter framework.
