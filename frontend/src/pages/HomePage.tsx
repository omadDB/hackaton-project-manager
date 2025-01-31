import { useEffect } from "react";
import Main from "../components/Home/Main";
import Navbar from "../components/Home/Navbar";
import Sidebar from "../components/Home/Sidebar";
import { useAppDispatch } from "../hooks/useAppDispatch";
import { boardAction } from "../store/reducers/board/boardSlice";
import { projectAction } from "../store/reducers/project/projectSlice";

const HomePage = () => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(boardAction.getAllBoard());
    dispatch(projectAction.getAllProject());
  });

  return (
    <div className="flex flex-col">
      <Navbar />
      <section className="flex mt-6">
        <div className="flex justify-center max-w-1160 mx-auto px-3">
          <Sidebar />
          <Main />
        </div>
      </section>
    </div>
  );
};

export default HomePage;
