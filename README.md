# CS193-Project

Project goal:

The goal of this project is to create a Java desktop application that automatically opens up other applications upon launch based on the users choices. This allows more organization and a more  customizable startup.

MVP scope:

- Enable or disable automatic launching of applications
- Save application settings between launches
- Display any error messages when an application cannot be launched

Future Plans:

- Being able to make multiple startup profiles. Example could be a "School work" profile that launches Brightspace from google automatically.
- Order of application launch and customizable delay

Tech Stack:

I am using Java as the main programming language with Swing for the GUI, Java ProcessBuilder to actually launch the Windows applications and Windows Startup Folder to Automatically run the applications after startup. 

Eisenhower Matrix:

Important and Urgent: the MVP
- Add applications using a file browser
- User can select which applications automatically launch
- Be able to save settings that persist after restarting

Important and Not Urgent: V2.0
- Be able to create customizable profiles for application launches
- Add customizable delays and order
- Allow users to orangize applications into different catagories

Not Important and Urgent: Library
- Learning to use ProcessBuilder to open applications
- Use Windows Startup Folder to launch the program at startup
- Use Gson so save application settings

Not Important and Deleted: 
- User accounts
- Fancy visual effects or animations
- Synchronization between different computers

